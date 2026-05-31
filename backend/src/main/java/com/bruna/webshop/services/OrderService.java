package com.bruna.webshop.services;

import com.bruna.webshop.dao.OrderDAO;
import com.bruna.webshop.dao.OrderItemDAO;
import com.bruna.webshop.dao.ProductDAO;
import com.bruna.webshop.dto.OrderDTO;
import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.OrderItem;
import com.bruna.webshop.modules.Product;
import com.bruna.webshop.modules.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final ProductDAO productDAO;
    private final OrderDAO orderDAO;
    private final OrderItemDAO orderItemDAO;
    private final UserDataService userdataService;

    public OrderService(ProductDAO productDAO, OrderDAO orderDAO, OrderItemDAO orderItemDAO, UserDataService userdataService) {
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
        this.orderItemDAO = orderItemDAO;
        this.userdataService = userdataService;
    }

    public ResponseEntity<Order> createOrder(List<OrderDTO> orderDTOList) {
        UserData userData = userdataService.getUserByToken();

        Order order = orderDAO.createOrder(userData);
        orderDAO.saveOrder(order);

        ArrayList<OrderItem> orderedProducts = new ArrayList<OrderItem>();

        for (OrderDTO orderRegelDTO : orderDTOList) {
            Optional<Product> productOptional = productDAO.getProductById(orderRegelDTO.getProductID());
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                OrderItem orderItem = orderItemDAO.createOrderItem(order, product, orderRegelDTO.getAmount());
                orderedProducts.add(orderItem);
                orderItemDAO.saveOrderItem(orderItem);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        order.setOrderItemList(orderedProducts);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
