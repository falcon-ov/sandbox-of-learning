package org.example.problem2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderManager {

    private final UserManager userManager;

    @Autowired
    public OrderManager(UserManager userManager) {
        this.userManager = userManager;
    }


}
