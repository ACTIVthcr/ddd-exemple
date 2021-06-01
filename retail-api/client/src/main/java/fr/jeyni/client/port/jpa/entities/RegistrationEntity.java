package fr.jeyni.client.port.jpa.entities;

import javax.persistence.*;

import lombok.*;

@Table(name = "REGISTRATION")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String phoneNumber;

	@Builder
	public RegistrationEntity(String email, String firstName, String name, String phoneNumber) {
		this.email = email;
		this.firstName = firstName;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
}
