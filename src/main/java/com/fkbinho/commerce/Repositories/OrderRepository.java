package com.fkbinho.commerce.Repositories;

import com.fkbinho.commerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
