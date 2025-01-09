package com.fkbinho.commerce.Services;

import com.fkbinho.commerce.Repositories.OrderRepository;
import com.fkbinho.commerce.Services.exceptions.ResourceNotFoundException;
import com.fkbinho.commerce.dto.OrderDTO;
import com.fkbinho.commerce.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado.")
        );
        return new OrderDTO(order);
    }
}
