package com.indevsolutions.example.cucumber.context;

public class TestContext {

	private Inventory inventory;

	public TestContext() {
		this.inventory = new Inventory();
	}

	public Inventory getInventory() {
		return inventory;
	}	

}
