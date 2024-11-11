package co.com.munamu.munamuinventory.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.com.munamu.munamuinventory.controller"})
public class MunamuinventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MunamuinventoryApplication.class, args);
	}

}
 