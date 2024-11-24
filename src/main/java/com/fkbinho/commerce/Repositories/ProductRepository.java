package com.fkbinho.commerce.Repositories;

import com.fkbinho.commerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
