package fr.jeyni.client.domain.client.service;

import fr.jeyni.client.domain.client.Client;
import fr.jeyni.client.domain.id.ClientId;

public interface ClientStore {

	Client get(ClientId clientId);

	void save(Client client);
}
