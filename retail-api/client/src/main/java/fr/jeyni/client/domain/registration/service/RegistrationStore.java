package fr.jeyni.client.domain.registration.service;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;

public interface RegistrationStore {

	Registration get(RegistrationId regId);

	RegistrationId save(Registration registration);
}
