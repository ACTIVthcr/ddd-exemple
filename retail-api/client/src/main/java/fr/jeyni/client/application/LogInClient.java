package fr.jeyni.client.application;

import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.registration.service.RegistrationService;

@Component
public class LogInClient {

	private RegistrationService registrationService;

	public LogInClient(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	public void execute(String mail, String password) {
		registrationService.authenticate(mail, password);
	}
}
