package com.fkbinho.commerce.Repositories;

import com.fkbinho.commerce.entities.OrderItem;
import com.fkbinho.commerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
