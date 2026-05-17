package com.bruna.webshop.dao;

import com.bruna.webshop.modules.UserData;
import com.bruna.webshop.modules.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAO {
    private OrderRepository orderRepository;

    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public Order createOrder(UserData gebruikergevens) {
        return new Order(gebruikergevens);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
