package com.bruna.webshop.dao;

import com.bruna.webshop.modules.UserData;
import com.bruna.webshop.modules.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAO {
    private final OrderRepository orderRepository;

    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }

    public Order createOrder(UserData userData) {
        return new Order(userData);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
