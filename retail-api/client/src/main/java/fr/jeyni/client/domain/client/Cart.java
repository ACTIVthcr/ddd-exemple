package fr.jeyni.client.domain.client;

import java.util.List;

import fr.jeyni.client.domain.id.CartId;
import fr.jeyni.client.domain.id.ItemId;

public record Cart(CartId id, List<ItemId> itemIds) {

}
