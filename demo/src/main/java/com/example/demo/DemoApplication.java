package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ContextApplication.xml");

		Player player = context.getBean("testPlayer", Player.class);
		System.out.println(player);
		player.toString();
		Player player2 = context.getBean("testPlayer", Player.class);
		System.out.println(player);
		System.out.println(player2);


		TwilightSparkle twilightSparkle = context.getBean("testTwilight", TwilightSparkle.class);
		twilightSparkle.playPony();

		Player pinkiePie = context.getBean("testPlayer", Player.class);
		System.out.println(pinkiePie);
		pinkiePie.toString();

		context.close();


	}
}
