package fr.jeyni.client.port.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeyni.client.port.jpa.entities.ClientEntity;

public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {

}
