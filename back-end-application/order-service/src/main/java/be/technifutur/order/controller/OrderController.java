package be.technifutur.order.controller;

import be.technifutur.order.business.service.OrderService;
import be.technifutur.order.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @GetMapping
    public List<OrderDTO> getOrdersByUser(Authentication auth) {
        return this.service.getOrdersByUser((UUID) auth.getPrincipal());
    }

}
