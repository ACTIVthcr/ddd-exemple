package fr.jeyni.client.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Address;
import fr.jeyni.client.domain.registration.Registration;
import fr.jeyni.client.domain.registration.service.RegistrationService;
import fr.jeyni.client.domain.registration.service.RegistrationStore;

@Component
public class RegisterClient {

	@Autowired
	private RegistrationStore registrationStore;
	@Autowired
	private RegistrationService registrationService;

	public RegistrationId execute(String email, String name, String firstName, Address billAddress,
			List<Address> deliveryAddress, String phoneNumber, String password) {
		Registration registration = Registration.registerClient(email, name, firstName, billAddress, deliveryAddress,
				phoneNumber);
		return registrationService.register(registration, password);
	}
}
