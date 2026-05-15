package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Boek;
import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.OrderRegel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderRegelDAO {
    private OrderRegelRepository orderRegelRepository;

    public OrderRegelDAO(OrderRegelRepository orderRegelRepository) {
        this.orderRegelRepository = orderRegelRepository;
    }

    public List<OrderRegel> getAllOrderRegels() {
        List<OrderRegel> orderRegels = orderRegelRepository.findAll();
        return orderRegels;
    }
    public OrderRegel createOrderRegel(Order order, Boek boek, int hoeveelheid){
        return new OrderRegel(order, boek, hoeveelheid);
    }

    public OrderRegel save(OrderRegel orderRegel) {
        return orderRegelRepository.save(orderRegel);
    }
}
