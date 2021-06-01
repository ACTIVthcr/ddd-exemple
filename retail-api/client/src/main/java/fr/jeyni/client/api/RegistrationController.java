package fr.jeyni.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeyni.client.api.model.RegisterForm;
import fr.jeyni.client.application.RegisterClient;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private RegisterClient registerClient;

	@PostMapping
	public Long registerClient(@RequestBody RegisterForm registerForm) {
		return registerClient.execute(registerForm.getEmail(), registerForm.getName(), registerForm.getFirstName(),
				registerForm.getBillAddress(), registerForm.getDeliveryAddress(), registerForm.getPhoneNumber(),
				registerForm.getPassword()).id();
	}
}
