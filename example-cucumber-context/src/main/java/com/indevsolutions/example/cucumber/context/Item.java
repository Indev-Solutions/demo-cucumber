package com.indevsolutions.example.cucumber.context;

import org.apache.commons.lang3.StringUtils;

public class Item {
	private String itemCode;
	private String description;
	private String sku;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String itemCode) {
		super();
		this.itemCode = itemCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
	    if (!(obj instanceof Item)) {
			return false;
		}
		
		// TODO Auto-generated method stub
		return StringUtils.equals(this.itemCode, ((Item)obj).getItemCode());
	}

}
