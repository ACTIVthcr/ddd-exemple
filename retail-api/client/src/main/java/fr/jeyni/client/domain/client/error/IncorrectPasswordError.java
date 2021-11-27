package fr.jeyni.client.domain.client.error;

import fr.jeyni.client.domain.error.DomainConstraintError;

public class IncorrectPasswordError extends DomainConstraintError {

	private static final String MESSAGE = "Incorrect password";
	private static final String CODE = "client_incorrect_password";

	public IncorrectPasswordError() {
		super(MESSAGE, CODE);
	}
}
