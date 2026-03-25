package com.api.constant;

public enum Platform {
	
	FST(3),FRENT_DESK(2);
	
	int code;

	Platform(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}


}
