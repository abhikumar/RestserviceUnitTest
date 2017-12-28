package com.integrationTest;

import java.net.URI;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.RestService;
import com.RestserviceUnitTestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestserviceUnitTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestServiceIntegrationTest {
	@LocalServerPort
	private int port;

	TestRestTemplate testRestTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void test() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(
				createURLWithPort("/hello/get"), HttpMethod.GET, entity,
				String.class);

		String expected = "{id:1,age:4,name:abhi}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
