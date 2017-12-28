package com.RestserviceUnitTest;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.CustService;
import com.RestService;
import com.model.Customer;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RestService.class)
public class RestserviceUnitTestApplicationTests {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CustService custService;
	
	
	
	Customer cust = new Customer(1,4,"abhi");
	
	@Test
	public void contextLoads() throws Exception {
		Mockito.when(custService.getCust()).thenReturn(cust);
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/hello/get").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
		System.out.println(mvcResult.getResponse());
		String expected = "{id:1,age:3,name:abhi}";
		System.out.println(mvcResult.getResponse().getContentAsString());
		
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(),false);
		
	}

}
