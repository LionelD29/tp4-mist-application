package be.technifutur.order.controller;

import be.technifutur.order.business.service.OrderService;
import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.form.OrderForm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    // CREATE NEW ORDER
    @PostMapping("/add")
    public OrderDTO placeOrder(Authentication auth, OrderForm form) {
        return service.placeOrder((UUID) auth.getPrincipal(), form);
    }

    // READ USER'S ORDERS LIST
    @GetMapping
    public List<OrderDTO> getOrdersByUser(Authentication auth) {
        return service.getOrdersByUser((UUID) auth.getPrincipal());
    }

}
