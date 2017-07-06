package com.talent.exchange.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.talent.exchange.demo.*")
public class DemoTalentExchangeApplicationServlet {
	public static void main(String[] args) {
		SpringApplication.run(DemoTalentExchangeApplicationServlet.class, args);
	}
}
