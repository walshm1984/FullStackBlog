package com.test.testapp.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.testapp.model.HelloWorldReturn;

@Controller
public class HelloWorldController {


	@RequestMapping(value = "/HelloWorld", method = RequestMethod.GET)
	public @ResponseBody String getHelloWorld()
	{
		String returnString="Hello World";
		return returnString;
	}
	
	@RequestMapping(value = "/HelloWorldObject", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HelloWorldReturn getHelloWorldObject()
	{
		return new HelloWorldReturn();
	}
	
	@RequestMapping(value = "/HelloWorldObject/{sayHelloParam}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HelloWorldReturn getHelloWorldObjectWithParam(@PathVariable("sayHelloParam") String helloParam)
	{
		return new HelloWorldReturn(helloParam);
	}
	
	@RequestMapping(value = "/HelloWorldPage/{helloName}", method = RequestMethod.GET)
	public String getHelloWorldPage(@PathVariable(value="helloName")String name,Model model,Locale locale)
	{
		DateFormat df= DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
		model.addAttribute("name", name);
		model.addAttribute("date", df.format(new Date()));
		return "helloworld";
	}
	
	@RequestMapping(value = "/HelloWorldPage/Complex/{helloName}", method = RequestMethod.GET)
	public String getHelloWorldPageComplex(@PathVariable(value="helloName")String name,Model model)
	{
		
		List<String> mList= new ArrayList<String>();
		for(int i=0;i<10;i++)
		{
			mList.add("Test "+i);
		}
		model.addAttribute("list", mList);
		model.addAttribute("helloworldobject", new HelloWorldReturn(name));
		return "looptest";
	}
	
	
	
}
