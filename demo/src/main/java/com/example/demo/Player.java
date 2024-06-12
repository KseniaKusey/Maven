package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("testPlayer")
@Scope("singleton")
class Player {

    private MyLittlePony myLittlePony;
    private MyLittlePony myLittlePony2;

    @Value("${player.phrase}")
    private String phrase;

    public Player(@Qualifier("testRarity") MyLittlePony myLittlePony, @Qualifier("testPinkie") MyLittlePony myLittlePony2 ) {
        this.myLittlePony = myLittlePony;
        this.myLittlePony2 = myLittlePony2;
    }

    @PostConstruct
    public void testInitMethod(){
        System.out.println("Init done");
    }
    @PreDestroy
    public void testDestroyMethod(){
        System.out.println("Destroy done");
    }

    @Override
    public String toString() {
        Rarity rarity;
        PinkiePie pinkiePie;
        if (myLittlePony instanceof Rarity) {
            rarity = (Rarity) myLittlePony;
            pinkiePie = (PinkiePie) myLittlePony2;
        }
        else{
            rarity = (Rarity) myLittlePony2;
            pinkiePie = (PinkiePie) myLittlePony;
        }
        return rarity.toString() + "\n" + pinkiePie.toString();



    }


}

