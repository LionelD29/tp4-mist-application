package be.technifutur.order.controller;

import be.technifutur.order.business.service.OrderService;
import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.form.OrderForm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    // READ ORDERS LIST OF A SPECIFIC USER
    @GetMapping
    public List<OrderDTO> getOrdersByUser(Authentication auth) {
        return service.getOrdersByUser((UUID) auth.getPrincipal());
    }

    // READ ONE ORDER OF A SPECIFIC USER
    @GetMapping("/{orderId}")
    public OrderDTO getOneUserOrderByOrderId(Authentication auth, @PathVariable Long orderId) {
        return service.getOneUserOrderByOrderId((UUID) auth.getPrincipal(), orderId);
    }

    // UPDATE ONE ORDER OF A SPECIFIC USER
//    @PatchMapping("/{orderId}/update")
//    public OrderDTO updateUserOrderByOrderId(Authentication auth, @PathVariable Long orderId, @RequestBody int quantity) {
//        return service.updateUserOrderByOrderId((UUID) auth.getPrincipal(), orderId, quantity);
//    }

    // DELETE ONE USER ORDER BY ID
    @DeleteMapping("/{orderId}")
    public OrderDTO deleteUserOrderById(Authentication auth, Long orderId) {
        return service.deleteUserOrderById((UUID) auth.getPrincipal(), orderId);
    }

}
