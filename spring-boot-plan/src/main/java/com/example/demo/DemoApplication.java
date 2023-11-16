package com.example.demo;
import io.sentry.Sentry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ResponseObject;

import java.util.Arrays;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*System.out.println("Hello world");

		try {
			throw new Exception("example error");
		} catch (Exception e) {
			Sentry.captureException(e);
		}*/
	}

	@GetMapping("/health-check")
	public ResponseEntity<ResponseObject> healthCheck() {
		ResponseObject response = new ResponseObject();
		response.setAccess_token("token");
		response.setExpires_in("1d");
		response.setToken_type("auth");
		return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
	}

}
