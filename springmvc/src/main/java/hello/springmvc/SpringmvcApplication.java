package hello.springmvc;

import hello.springmvc.basic.LogTestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringmvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);

	}

}
