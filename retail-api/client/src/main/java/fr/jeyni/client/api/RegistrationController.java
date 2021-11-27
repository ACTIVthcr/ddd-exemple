package fr.jeyni.client.api;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeyni.client.api.model.LogInForm;
import fr.jeyni.client.api.model.RegisterForm;
import fr.jeyni.client.api.model.mapper.AddressModelMapper;
import fr.jeyni.client.application.LogInClient;
import fr.jeyni.client.application.RegisterClient;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	private RegisterClient registerClient;
	private LogInClient logInClient;

	public RegistrationController(RegisterClient registerClient, LogInClient logInClient) {
		this.logInClient = logInClient;
		this.registerClient = registerClient;
	}

	@PostMapping("/auth")
	public void logInClient(@RequestBody LogInForm logInForm) {
		logInClient.execute(logInForm.getEmail(), logInForm.getPassword());
	}

	@PostMapping
	public Long registerClient(@RequestBody RegisterForm registerForm) {
		return registerClient.execute(registerForm.getEmail(), registerForm.getName(), registerForm.getFirstName(),
				AddressModelMapper.modelToDomain(registerForm.getBillAddress()),
				registerForm.getDeliveryAddress() == null ?
				Collections.emptyList() :
				registerForm.getDeliveryAddress().stream().map(AddressModelMapper::modelToDomain)
						.collect(Collectors.toList()), registerForm.getPhoneNumber(), registerForm.getPassword()).id();
	}
}
