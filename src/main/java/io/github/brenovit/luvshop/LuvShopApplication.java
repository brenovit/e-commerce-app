package io.github.brenovit.luvshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class LuvShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuvShopApplication.class, args);
	}

}
