package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Product;
import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemDAO {
    private final OrderItemRepository orderItemRepository;

    public OrderItemDAO(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        return orderItemList;
    }

    public OrderItem createOrderItem(Order order, Product product, int amount){
        return new OrderItem(order, product, amount);
    }

    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}
