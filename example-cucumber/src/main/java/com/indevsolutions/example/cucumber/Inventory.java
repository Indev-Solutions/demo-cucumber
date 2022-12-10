package com.indevsolutions.example.cucumber;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class Inventory {

	private Set<InventoryLine> inventoryLines;

	public Set<InventoryLine> getInventoryLines() {
		return inventoryLines;
	}

	public void setInventoryLines(Set<InventoryLine> inventoryLines) {
		this.inventoryLines = inventoryLines;
	}

	public boolean relocate(String itemCode, Integer qty, String sourceLocation, String targetLocation) {

		var item = new Item(itemCode);

		InventoryLine line = inventoryLines.stream().filter(l -> l.getItem().equals(item)
				&& StringUtils.equals(l.getLocation(), sourceLocation) && l.getQuantity().compareTo(qty) >= 0)
				.findFirst().orElse(null);

		if (line == null) {
			return false;
		}

		if (line.getQuantity().compareTo(qty) == 0) {
			line.setLocation(targetLocation);

		} else {
			line.reduceQuantity(qty);

			var newLine = new InventoryLine();
			newLine.setItem(item);
			newLine.setLocation(targetLocation);
			newLine.setQuantity(qty);
			inventoryLines.add(newLine);
		}

		return true;
	}

}
