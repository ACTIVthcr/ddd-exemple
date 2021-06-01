package fr.jeyni.client.port.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeyni.client.port.jpa.entities.RegistrationEntity;

public interface RegistrationEntityRepository extends JpaRepository<RegistrationEntity, Long> {

}
