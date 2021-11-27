package fr.jeyni.client.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.client.error.IncorrectPasswordError;
import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;
import fr.jeyni.client.domain.registration.service.RegistrationService;
import fr.jeyni.client.port.jpa.entities.RegistrationEntity;
import fr.jeyni.client.port.jpa.repository.RegistrationEntityRepository;
import fr.jeyni.client.service.mapper.RegistrationEntityMapper;

@Component
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationEntityRepository registrationEntityRepository;

	public RegistrationServiceImpl(RegistrationEntityRepository registrationEntityRepository) {
		this.registrationEntityRepository = registrationEntityRepository;
	}

	@Override
	public void authenticate(String mail, String password) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Optional<RegistrationEntity> registrationEntityOpt = registrationEntityRepository.findByEmail(mail);
		if (registrationEntityOpt.isEmpty() || !bcrypt.matches(password, registrationEntityOpt.get().getPassword())) {
			throw new IncorrectPasswordError();
		}
	}

	@Override
	public RegistrationId register(Registration registration, String password) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encodePassword = bcrypt.encode(password);
		RegistrationEntity registrationEntity = RegistrationEntityMapper.domainToEntity(registration, encodePassword);
		registrationEntity.setPassword(encodePassword);
		return new RegistrationId(registrationEntityRepository.save(registrationEntity).getId());
	}
}
