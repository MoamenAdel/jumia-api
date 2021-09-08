package com.jumia.phonechecker.model;

public enum NumberEnum {

	CAMEROON("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$","237"),
	ETHIOPIA("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$","251"),
	MOROCCO("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$","212"),
	MOZAMBIQUE("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$","258"),
	UGANDA("Uganda", "\\(256\\)\\ ?\\d{9}$","256");

	private String countryName;
	private String countryRegex;
	private String countryCode;

	private NumberEnum(String countryName, String countryRegex, String countryCode) {
		this.countryName = countryName;
		this.countryRegex = countryRegex;
		this.countryCode = countryCode;
	}
	
	public String getCountryRegex() {
		return countryRegex;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}
}
