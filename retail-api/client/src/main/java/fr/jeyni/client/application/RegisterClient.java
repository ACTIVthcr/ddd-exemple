package fr.jeyni.client.application;

import java.util.List;

import fr.jeyni.client.domain.registration.Address;
import fr.jeyni.client.domain.registration.Registration;

public class RegisterClient {

	public void execute(String email, String name, String firstName, Address billAddress, List<Address> deliveryAddress,
			String phoneNumber, String password) {
		Registration registration = Registration.registerClient(email, name, firstName, billAddress, deliveryAddress,
				phoneNumber);
	}
}
