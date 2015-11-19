package com.test.testapp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.testapp.controller.HelloWorldController;
import com.test.testapp.model.HelloWorldReturn;

public class HelloWorldControllerTest {
	@Test
	public final void testHelloWorld()
	{
		HelloWorldController mCon= new HelloWorldController();
		String returnWorld=mCon.getHelloWorld();
		assertEquals(returnWorld,"Hello World");
	}
	@Test
	public final void testHelloWorldObject()
	{
		HelloWorldController mCon= new HelloWorldController();
		HelloWorldReturn returnWorld=mCon.getHelloWorldObject();
		assertEquals(returnWorld,new HelloWorldReturn());
	}
}
