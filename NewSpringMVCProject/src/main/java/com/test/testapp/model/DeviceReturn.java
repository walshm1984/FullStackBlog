package com.test.testapp.model;

public class DeviceReturn {

	public DeviceReturn(String browserType, String deviceType) {
		this.browserType = browserType;
		this.deviceType = deviceType;
	}

	private String browserType;
	private String deviceType;

	public String getDeviceType() {
		return deviceType;
	}

	public String getBrowserType() {
		return browserType;
	}

}
