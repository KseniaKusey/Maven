package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("testPinkie")
class PinkiePie extends Phrases implements MyLittlePony {
    @Value("${player.power}")
    private String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public PinkiePie() {
        phrase = "I'm Pinkie, and I love parties! ";
    }

    @Override
    public String toString() {
        return "MyLittlePony:" + phrase + ", My power is:" + power;
    }
}


