package com.thaontm.demo.demoThaoTodo;
//
//import com.thaontm.demo.demoThaoTodo.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoThaoTodoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoThaoTodoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoThaoTodoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(CategoryRepository repository) {
//		return (args) -> {
//			repository.findAll().forEach((user) -> {log.error(user.toString());});
//		};
//	}
}
