package pt.itsector.itsbackoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.jfr.Registered;
import lombok.Getter;

@SpringBootApplication
public class ItsbackofficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsbackofficeApplication.class, args);
	}
}
