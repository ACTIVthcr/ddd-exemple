package fr.jeyni.client.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.registration.service.RegistrationService;

@Component
public class LogInClient {

	@Autowired
	private RegistrationService registrationService;

	public void execute(String mail, String password) {
		registrationService.authenticate(mail, password);
	}
}
