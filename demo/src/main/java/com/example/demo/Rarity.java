package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("testRarity")
 class Rarity extends Phrases implements MyLittlePony {
     @Value("${player.power2}")
     private String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Rarity() {
         phrase = " I'm Rarity. I like fashion!";
     }

     @Override
     public String toString() {
         return "MyLittlePony:" + phrase + ", My power is:" + power;
     }
}
