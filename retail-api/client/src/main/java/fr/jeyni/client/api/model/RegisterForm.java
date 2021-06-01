package fr.jeyni.client.api.model;

import java.util.List;

import fr.jeyni.client.domain.registration.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterForm {

	String email;
	String name;
	String firstName;
	Address billAddress;
	List<Address> deliveryAddress;
	String phoneNumber;
	String password;
}
