package com.cards.creditcard.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cards.creditcard.model.CreditCardStatement;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreditCardStatementServiceTests {

	@Mock
	private com.cards.creditcard.repository.CreditCardStatementRepository repository;

	@InjectMocks
	private CreditCardStatementService service;

	public CreditCardStatementServiceTests() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetStatements() {
		LocalDate startDate = LocalDate.of(2021, 1, 1);
		LocalDate endDate = LocalDate.of(2021, 1, 31);
		CreditCardStatement statement = new CreditCardStatement(1L, "1234-5678-9876-5432", startDate, endDate, 100.0);
		when(repository.findAll()).thenReturn(Collections.singletonList(statement));

		List<CreditCardStatement> statements = service.getStatements(startDate, endDate);
		assertEquals(1, statements.size());
		assertEquals("1234-5678-9876-5432", statements.get(0).getCardNumber());
	}
}
