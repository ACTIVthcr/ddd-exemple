package fr.jeyni.client.port.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeyni.client.port.jpa.entities.RegistrationEntity;

public interface RegistrationEntityRepository extends JpaRepository<RegistrationEntity, Long> {

	Optional<RegistrationEntity> findByEmail(String email);
}
