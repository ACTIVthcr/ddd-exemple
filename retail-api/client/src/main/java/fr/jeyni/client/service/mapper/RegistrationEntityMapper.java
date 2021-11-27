package fr.jeyni.client.service.mapper;

import java.util.Collections;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;
import fr.jeyni.client.port.jpa.entities.RegistrationEntity;

public class RegistrationEntityMapper {

	private RegistrationEntityMapper() throws IllegalAccessException {
		throw new IllegalAccessException("Utility class");
	}

	public static RegistrationEntity domainToEntity(Registration registration, String password) {
		return new RegistrationEntity(registration.email(), registration.firstName(), registration.name(),
				registration.phoneNumber(), password);
	}

	public static Registration entityToDomain(RegistrationEntity registrationEntity) {
		return new Registration(new RegistrationId(registrationEntity.getId()), registrationEntity.getEmail(),
				registrationEntity.getFirstName(), registrationEntity.getName(), null, Collections.emptyList(),
				registrationEntity.getPhoneNumber());
	}
}
