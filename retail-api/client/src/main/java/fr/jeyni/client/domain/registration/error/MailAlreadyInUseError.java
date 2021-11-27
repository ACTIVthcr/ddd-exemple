package fr.jeyni.client.domain.registration.error;

import fr.jeyni.client.domain.error.DomainConstraintError;

public class MailAlreadyInUseError extends DomainConstraintError {

	private static final String MESSAGE = "Mail already in use";
	private static final String CODE = "register_mail_already_in_use";

	public MailAlreadyInUseError() {
		super(MESSAGE, CODE);
	}
}
