package com.fkbinho.commerce.Services;

import com.fkbinho.commerce.Services.exceptions.ForbiddenException;
import com.fkbinho.commerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfForAdmin(Long userId) {
        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }

}
