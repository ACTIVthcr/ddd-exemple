package fr.kleecontrib.port.jpa.entities;

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
	@Column(name = "REG_ID")
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
	@Getter
	@Setter
	private String password;

	@Builder
	public RegistrationEntity(String email, String firstName, String name, String phoneNumber, String password) {
		this.email = email;
		this.firstName = firstName;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
}
