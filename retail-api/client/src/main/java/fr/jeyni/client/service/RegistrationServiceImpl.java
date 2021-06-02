package fr.jeyni.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import fr.jeyni.client.domain.id.RegistrationId;
import fr.jeyni.client.domain.registration.Registration;
import fr.jeyni.client.domain.registration.service.RegistrationService;
import fr.jeyni.client.port.jpa.entities.RegistrationEntity;
import fr.jeyni.client.port.jpa.repository.RegistrationEntityRepository;
import fr.jeyni.client.service.mapper.RegistrationEntityMapper;

@Component
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationEntityRepository registrationEntityRepository;

	@Override
	public void authenticate(String mail, String password) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		RegistrationEntity registrationEntity = registrationEntityRepository.findByEmail(mail);
		if (registrationEntity == null || !bcrypt.matches(password, registrationEntity.getPassword())) {
			throw new RuntimeException("BAD PASSWORD");
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
