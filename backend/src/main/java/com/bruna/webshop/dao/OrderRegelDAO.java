package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Product;
import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRegelDAO {
    private OrderItemRepository orderItemRepository;

    public OrderRegelDAO(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderRegels() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems;
    }
    public OrderItem createOrderRegel(Order order, Product product, int hoeveelheid){
        return new OrderItem(order, product, hoeveelheid);
    }

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
