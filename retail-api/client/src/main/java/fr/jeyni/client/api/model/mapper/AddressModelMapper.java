package fr.jeyni.client.api.model.mapper;

import fr.jeyni.client.api.model.AddressModel;
import fr.jeyni.client.domain.registration.Address;

public class AddressModelMapper {

	public static Address modelToDomain(AddressModel model) {
		return Address.hydrate(model.getNumber(), model.getRoad(), model.getCity(), model.getZipCode(),
				model.getCountry(), model.isCurrent());
	}
}
