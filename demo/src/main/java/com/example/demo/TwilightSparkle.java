package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("testTwilight")
class TwilightSparkle extends Phrases implements MyLittlePony {

    @Autowired
    private TwilightSparkle twilightSparkle;



    public TwilightSparkle() {
        phrase = " My name is Twilight Sparkle and I'm unicorn!";

    }
    public void TwilightSparkle (TwilightSparkle myLittlePony1) {this.twilightSparkle = myLittlePony1; }

    public void playPony() {
        System.out.println("Персонаж:" + twilightSparkle.toString());
    }

}
//String phrase = "My name is Twilight Sparkle and I'm unicorn!";