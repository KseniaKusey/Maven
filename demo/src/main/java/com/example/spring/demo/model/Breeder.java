package com.example.spring.demo.model;

import com.example.spring.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("breeder")
public class Breeder {
    private Cat currentCat;
    private Cat previousCat;
    private Cat nextCat;

    @Autowired
    public Breeder(@Qualifier("First Cat") Cat currentCat,
                   @Qualifier("Second Cat") Cat previousCat,
                   @Qualifier("Third Cat") Cat nextCat) {
        this.currentCat = currentCat;
        this.previousCat = previousCat;
        this.nextCat = nextCat;
    }
}
