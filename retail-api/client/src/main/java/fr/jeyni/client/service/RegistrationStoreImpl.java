package fr.jeyni.client.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;
import fr.jeyni.client.domain.registration.service.RegistrationStore;
import fr.jeyni.client.port.jpa.repository.RegistrationEntityRepository;
import fr.jeyni.client.service.mapper.RegistrationEntityMapper;

@Component
public class RegistrationStoreImpl implements RegistrationStore {

	private RegistrationEntityRepository registrationEntityRepository;

	public RegistrationStoreImpl(RegistrationEntityRepository registrationEntityRepository) {
		this.registrationEntityRepository = registrationEntityRepository;
	}

	@Override
	public Registration get(RegistrationId regId) {
		return RegistrationEntityMapper.entityToDomain(registrationEntityRepository.getById(regId.id()));
	}

	@Override
	public Optional<Registration> getRegistrationByMail(String email) {
		return registrationEntityRepository.findByEmail(email).map(RegistrationEntityMapper::entityToDomain);
	}
}
