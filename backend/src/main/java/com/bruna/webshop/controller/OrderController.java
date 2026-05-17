package com.bruna.webshop.controller;

import com.bruna.webshop.dao.ProductDAO;
import com.bruna.webshop.dao.UserDataDAO;
import com.bruna.webshop.dao.OrderDAO;
import com.bruna.webshop.dao.OrderItemDAO;
import com.bruna.webshop.dto.OrderDTO;
import com.bruna.webshop.modules.Product;
import com.bruna.webshop.modules.UserData;
import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.OrderItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
    private final ProductDAO productDAO;
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private UserDataDAO userDataDAO;

    public OrderController(ProductDAO productDAO, OrderDAO orderDAO, OrderItemDAO orderItemDAO, UserDataDAO userDataDAO) {
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
        this.orderItemDAO = orderItemDAO;
        this.userDataDAO = userDataDAO;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody List<OrderDTO> orderRegels) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String gebruikerEmail = (String) authentication.getPrincipal();

        UserData gebruikergevens = userDataDAO.getUserDataByEmail(gebruikerEmail);

        Order order = orderDAO.createOrder(gebruikergevens);
        orderDAO.saveOrder(order);

        ArrayList<OrderItem> besteldeBoeken = new ArrayList<OrderItem>();

        for (OrderDTO orderRegelDTO : orderRegels) {
            Optional<Product> boekOpt = productDAO.getProductById(orderRegelDTO.getProductID());
            if (boekOpt.isPresent()) {
                Product product = boekOpt.get();
                OrderItem orderItem = orderItemDAO.createOrderItem(order, product, orderRegelDTO.getAmount());
                besteldeBoeken.add(orderItem);
                orderItemDAO.saveOrderItem(orderItem);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        order.setOrderItemList(besteldeBoeken);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
