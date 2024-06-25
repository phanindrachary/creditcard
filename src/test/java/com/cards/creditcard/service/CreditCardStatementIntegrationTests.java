package com.cards.creditcard.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cards.creditcard.controller.CreditCardStatementController;
import com.cards.creditcard.model.CreditCardStatement;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardStatementIntegrationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private CreditCardStatementController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void testGetStatements() {
		String url = "http://localhost:" + port + "/creditcard/api/getstatements?start=2021-01-01&end=2021-01-31";
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("1234-5678-9876-5432");
	}

	@Test
	public void testCreateStatement() {
		String url = "http://localhost:" + port + "/creditcard/api/savestatement";
		CreditCardStatement statement = new CreditCardStatement(null, "1234-5678-9876-5432", LocalDate.of(2021, 1, 1),
				LocalDate.of(2021, 1, 31), 100.0);

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CreditCardStatement> request = new HttpEntity<>(statement, headers);

		ResponseEntity<CreditCardStatement> response = this.restTemplate.postForEntity(url, request,
				CreditCardStatement.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCardNumber()).isEqualTo("1234-5678-9876-5432");
	}

	@Test
	public void testCreateInvalidStatement() {
		String url = "http://localhost:" + port + "/creditcard/api/savestatement";
		CreditCardStatement statement = new CreditCardStatement(null, "invalid-card-number", LocalDate.of(2021, 1, 1),
				LocalDate.of(2021, 1, 31), 100.0);

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CreditCardStatement> request = new HttpEntity<>(statement, headers);

		ResponseEntity<Map> response = this.restTemplate.postForEntity(url, request, Map.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(response.getBody()).containsKey("cardNumber");
	}
}
