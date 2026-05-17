package com.bruna.webshop.controller;

import com.bruna.webshop.dao.BoekDAO;
import com.bruna.webshop.dao.GebruikerGegevensDAO;
import com.bruna.webshop.dao.OrderDAO;
import com.bruna.webshop.dao.OrderRegelDAO;
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
    private final BoekDAO boekDAO;
    private OrderDAO orderDAO;
    private OrderRegelDAO orderRegelDAO;
    private GebruikerGegevensDAO gebruikerGegevensDAO;

    public OrderController(BoekDAO boekDAO, OrderDAO orderDAO, OrderRegelDAO orderRegelDAO, GebruikerGegevensDAO gebruikerGegevensDAO) {
        this.boekDAO = boekDAO;
        this.orderDAO = orderDAO;
        this.orderRegelDAO = orderRegelDAO;
        this.gebruikerGegevensDAO = gebruikerGegevensDAO;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody List<OrderDTO> orderRegels) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String gebruikerEmail = (String) authentication.getPrincipal();

        UserData gebruikergevens = gebruikerGegevensDAO.getByEmail(gebruikerEmail);

        Order order = orderDAO.createOrder(gebruikergevens);
        orderDAO.save(order);

        ArrayList<OrderItem> besteldeBoeken = new ArrayList<OrderItem>();

        for (OrderDTO orderRegelDTO : orderRegels) {
            Optional<Product> boekOpt = boekDAO.getBoekById(orderRegelDTO.getBoekID());
            if (boekOpt.isPresent()) {
                Product product = boekOpt.get();
                OrderItem orderItem = orderRegelDAO.createOrderRegel(order, product, orderRegelDTO.getHoeveelheid());
                besteldeBoeken.add(orderItem);
                orderRegelDAO.save(orderItem);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        order.setOrderItemList(besteldeBoeken);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
