package fr.jeyni.client.domain.registration.service;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;

public interface RegistrationService {

	void authenticate(String mail, String password);

	RegistrationId register(Registration registration, String password);
}
