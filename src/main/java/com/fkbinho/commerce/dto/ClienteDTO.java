package com.fkbinho.commerce.dto;

import com.fkbinho.commerce.entities.User;

public class ClienteDTO {

    private Long id;
    private String name;

    public ClienteDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClienteDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
