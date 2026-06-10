package com.bruna.webshop.controller;

import com.bruna.webshop.dto.OrderDTO;
import com.bruna.webshop.modules.Product;
import com.bruna.webshop.modules.UserData;
import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.OrderItem;
import com.bruna.webshop.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody List<OrderDTO> orderDTOList) {
        return orderService.createOrder(orderDTOList);
    }
}
