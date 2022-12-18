package com.indevsolutions.example.cucumber.context;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;

public class ItemSteps {
	
	private Inventory inventory;
	
	public ItemSteps(TestContext context) {
		this.inventory = context.getInventory();
	}
	
	@Given("the following items")
	public void theFollowingItems(List<Item> items) {
		this.inventory.setItems(new HashSet<>(items));
	}
	
	@DataTableType
	public Item mapItems(Map<String, String> data) {
		var item = new Item();
		item.setItemCode(data.get("item code"));
		item.setDescription(data.get("description"));
		item.setSku(data.get("sku"));
		return item;
	}

}
