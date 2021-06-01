package fr.jeyni.client.domain.client;

import fr.jeyni.client.domain.id.ClientId;

public record Client(ClientId id, Cart cart) {

}
