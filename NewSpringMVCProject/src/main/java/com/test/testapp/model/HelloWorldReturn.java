package com.test.testapp.model;

import java.util.Date;

public class HelloWorldReturn {

	public HelloWorldReturn() {
		this.value = "Hello World";
		this.timeCreated = new Date();
	}
	
	public HelloWorldReturn(String value) {
		this.value = "Hello "+value;
		this.timeCreated = new Date();
	}

	private Date timeCreated;
	private String value;

	public Date getTimeCreated() {
		return timeCreated;
	}

	public String getValue() {
		return value;
	}
	@Override
	public boolean equals(Object other)
	{
		if(other instanceof HelloWorldReturn&&((HelloWorldReturn) other).getValue()==this.getValue())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
