package com.fkbinho.commerce.Services;

import com.fkbinho.commerce.Repositories.OrderItemRepository;
import com.fkbinho.commerce.Repositories.OrderRepository;
import com.fkbinho.commerce.Repositories.ProductRepository;
import com.fkbinho.commerce.Services.exceptions.ResourceNotFoundException;
import com.fkbinho.commerce.dto.OrderDTO;
import com.fkbinho.commerce.dto.OrderItemDTO;
import com.fkbinho.commerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado.")
        );

        authService.validateSelfForAdmin(order.getClient().getId());

        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for(OrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order,product, itemDTO.getQuantity(), product.getPrice());

            order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
