package com.indevsolutions.example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	private Inventory inventory = new Inventory();

	@Given("an inventory with the following items")
	public void anInventoryWithTheFollowingItems(List<InventoryLine> inventoryLines) {
		inventory.setInventoryLines(new HashSet<>(inventoryLines));
	}

	@When("users relocate the following inventory to the location {string}")
	public void relocate(String targetLocation, List<InventoryLine> inventoryLines) {
		var inventoryLine = inventoryLines.get(0);
		inventory.relocate(inventoryLine.getItem().getItemCode(), inventoryLine.getQuantity(),
				inventoryLine.getLocation(), targetLocation);
	}
	
	@Then("the expected inventory is the following")
	public void ss(List<InventoryLine> expectedInventoryLines) {
		
		assertNotNull(inventory.getInventoryLines());
		assertEquals(expectedInventoryLines.size(),inventory.getInventoryLines().size());
		for(var line : inventory.getInventoryLines()) {
			
			var expectedLine = expectedInventoryLines.stream().filter(l-> StringUtils.equals(l.getLocation(), line.getLocation())).findFirst().orElse(null);
			assertNotNull(expectedLine);
			
			assertEquals(expectedLine.getItem(), line.getItem());
			assertEquals(expectedLine.getQuantity(), line.getQuantity());
		}
		
	}
	
	@DataTableType
	public InventoryLine mapInventoryLine(Map<String, String> data) {
		var line = new InventoryLine();
		line.setItem(new Item(data.get("item code")));
		line.setQuantity(Integer.valueOf(data.get("qty")));
		line.setLocation(data.get("location"));
		return line;
	}

}
