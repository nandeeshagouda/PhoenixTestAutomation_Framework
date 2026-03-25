package com.api.constant;

public enum Product {
	
	NEXS_2(1),PIXEL(2);
	
	int code;
	private Product(int code) {
		this.code=code;
		
	}
	
	public int getCode() {
		return code;
	}
}
