package fr.jeyni.client.application;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Address;
import fr.jeyni.client.domain.registration.Registration;
import fr.jeyni.client.domain.registration.error.MailAlreadyInUseError;
import fr.jeyni.client.domain.registration.service.RegistrationService;
import fr.jeyni.client.domain.registration.service.RegistrationStore;

@Component
public class RegisterClient {

	private RegistrationStore registrationStore;
	private RegistrationService registrationService;

	public RegisterClient(RegistrationStore registrationStore, RegistrationService registrationService) {
		this.registrationStore = registrationStore;
		this.registrationService = registrationService;
	}

	public RegistrationId execute(String email, String name, String firstName, Address billAddress,
			List<Address> deliveryAddress, String phoneNumber, String password) {
		/// Uniq mail by registration
		if (registrationStore.getRegistrationByMail(email).isPresent()) {
			throw new MailAlreadyInUseError();
		}
		/// Register client
		Registration registration = Registration.registerClient(email, name, firstName, billAddress, deliveryAddress,
				phoneNumber);
		return registrationService.register(registration, password);
	}
}
