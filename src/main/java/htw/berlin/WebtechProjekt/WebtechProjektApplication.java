package htw.berlin.WebtechProjekt;

import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import htw.berlin.WebtechProjekt.Services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class WebtechProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtechProjektApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}