package com.test.testapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;

import com.test.testapp.model.DeviceReturn;

@Controller
public class DeviceDetectionController {

	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public @ResponseBody DeviceReturn getDevice(HttpServletRequest request,Device device)
	{
		String devicetype="";
		if(device.isMobile())
		{
			devicetype="mobile";
		}
		else if(device.isNormal())
		{
			devicetype="Desktop";
		}else if(device.isTablet())
		{
			devicetype="mobile";
		}
		String browserName =request.getHeader("user-agent");
		
		
		return new DeviceReturn(browserName,devicetype);
	}
	
}
