package org.example.problem1;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AService {

    private final BService b;

    public AService(@Lazy BService b){
        this.b = b;
    }
}
