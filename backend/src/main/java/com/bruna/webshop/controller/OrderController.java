package com.bruna.webshop.controller;

import com.bruna.webshop.dao.BoekDAO;
import com.bruna.webshop.dao.GebruikerGegevensDAO;
import com.bruna.webshop.dao.OrderDAO;
import com.bruna.webshop.dao.OrderRegelDAO;
import com.bruna.webshop.dto.OrderDTO;
import com.bruna.webshop.modules.Boek;
import com.bruna.webshop.modules.GebruikerGegevens;
import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.OrderRegel;
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

        GebruikerGegevens gebruikergevens = gebruikerGegevensDAO.getByEmail(gebruikerEmail);

        Order order = orderDAO.createOrder(gebruikergevens);
        orderDAO.save(order);

        ArrayList<OrderRegel> besteldeBoeken = new ArrayList<OrderRegel>();

        for (OrderDTO orderRegelDTO : orderRegels) {
            Optional<Boek> boekOpt = boekDAO.getBoekById(orderRegelDTO.getBoekID());
            if (boekOpt.isPresent()) {
                Boek boek = boekOpt.get();
                OrderRegel orderRegel = orderRegelDAO.createOrderRegel(order, boek, orderRegelDTO.getHoeveelheid());
                besteldeBoeken.add(orderRegel);
                orderRegelDAO.save(orderRegel);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        order.setBesteldeBoeken(besteldeBoeken);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
