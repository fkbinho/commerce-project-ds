package com.fkbinho.commerce.Services;

import com.fkbinho.commerce.Repositories.ProductRepository;
import com.fkbinho.commerce.dto.ProductDTO;
import com.fkbinho.commerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }
}