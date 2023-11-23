package com.example.demo;
import io.sentry.Sentry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ResponseObject;
import com.example.demo.database.Blog;
import com.example.demo.database.BlogController;

import java.util.Arrays;


@EnableJpaRepositories("com.example.demo.*")
@ComponentScan(basePackages = { "com.example.demo.*" })
@EntityScan("com.example.demo.*")   

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private BlogController blogController;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*System.out.println("Hello world");

		try {
			throw new Exception("example error");
		} catch (Exception e) {
			Sentry.captureException(e);
		}*/
	}

	@GetMapping("/fetch-blog")
	public ResponseEntity<Blog> getBlog() {
		Blog blog = blogController.show("1");
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

}
