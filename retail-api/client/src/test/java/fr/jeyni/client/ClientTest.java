package fr.jeyni.client;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.jeyni.client.domain.id.ClientId;
import fr.jeyni.client.domain.id.RegistrationId;

public class ClientTest {

	@Test
	void record_RegistrationId_test() {
		RegistrationId registrationId1 = new RegistrationId(1L);
		RegistrationId registrationId2 = new RegistrationId(1L);
		Assertions.assertThat(registrationId1.id()).isEqualTo(1L);
		Assertions.assertThat(registrationId1).isEqualTo(registrationId2);
	}

	@Test
	void record_clientId_test() {
		ClientId clientId1 = new ClientId(1L);
		ClientId clientId2 = new ClientId(1L);
		Assertions.assertThat(clientId1.id()).isEqualTo(1L);
		Assertions.assertThat(clientId1).isEqualTo(clientId2);
	}
}
