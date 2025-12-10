package org.example.problem1;

import org.springframework.stereotype.Service;

@Service
public class BService {
    private final AService a;

    public BService(AService a){
        this.a = a;
    }
}
