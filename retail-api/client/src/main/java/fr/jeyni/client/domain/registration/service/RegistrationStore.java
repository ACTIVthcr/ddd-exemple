package fr.jeyni.client.domain.registration.service;

import java.util.Optional;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;

public interface RegistrationStore {

	Registration get(RegistrationId regId);

	Optional<Registration> getRegistrationByMail(String email);
}
