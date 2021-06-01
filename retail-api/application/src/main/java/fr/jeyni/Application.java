package fr.jeyni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import fr.jeyni.client.port.jpa.repository.RegistrationEntityRepository;

@ComponentScan(basePackages = { "fr.jeyni" })
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Autowired
	private RegistrationEntityRepository registrationEntityRepository;

	@SuppressWarnings("squid:S4823")
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
