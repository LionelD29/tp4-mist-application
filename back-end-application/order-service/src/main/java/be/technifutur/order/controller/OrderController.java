package be.technifutur.order.controller;

import be.technifutur.order.business.service.OrderService;
import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.form.OrderForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public ResponseEntity<OrderDTO> placeOrder(Authentication auth, OrderForm form) {
        return ResponseEntity.ok(service.placeOrder((UUID) auth.getPrincipal(), form));
    }

    // READ ORDERS LIST OF A SPECIFIC USER
    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrdersByUser(Authentication auth) {
        return ResponseEntity.ok(service.getOrdersByUser((UUID) auth.getPrincipal()));
    }

    // READ ONE ORDER OF A SPECIFIC USER
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOneUserOrderByOrderId(Authentication auth, @PathVariable Long orderId) {
        return ResponseEntity.ok(service.getOneUserOrderByOrderId((UUID) auth.getPrincipal(), orderId));
    }

    // DELETE ONE USER ORDER BY ID
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderDTO> deleteUserOrderById(Authentication auth, Long orderId) {
        return ResponseEntity.ok(service.deleteUserOrderById((UUID) auth.getPrincipal(), orderId));
    }

}
