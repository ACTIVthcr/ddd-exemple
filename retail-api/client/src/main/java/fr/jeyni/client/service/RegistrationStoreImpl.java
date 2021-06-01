package fr.jeyni.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;
import fr.jeyni.client.domain.registration.service.RegistrationStore;
import fr.jeyni.client.port.jpa.entities.RegistrationEntity;
import fr.jeyni.client.port.jpa.repository.RegistrationEntityRepository;
import fr.jeyni.client.service.mapper.RegistrationEntityMapper;

@Component
public class RegistrationStoreImpl implements RegistrationStore {

	@Autowired
	private RegistrationEntityRepository registrationEntityRepository;

	@Override
	public Registration get(RegistrationId regId) {
		return RegistrationEntityMapper.entityToDomain(registrationEntityRepository.getById(regId.id()));
	}

	@Override
	public RegistrationId save(Registration registration) {
		RegistrationEntity entity = registrationEntityRepository.save(
				RegistrationEntityMapper.domainToEntity(registration));
		return new RegistrationId(entity.getId());
	}
}
