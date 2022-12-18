package com.indevsolutions.example.cucumber.context;

public class InventoryLine {

	private Item item;
	private Integer quantity;
	private String location;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean reduceQuantity(Integer quantity) {
		if (quantity > this.quantity) {
			return false;
		}
		this.quantity = this.quantity - quantity;
		return true;
	}

}
