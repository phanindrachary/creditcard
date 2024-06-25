package com.cards.creditcard.service;

import java.time.LocalDate;
import java.util.List;

import com.cards.creditcard.model.CreditCardStatement;

public interface CreditCardStatementService {

	List<CreditCardStatement> getStatements(LocalDate startDate, LocalDate endDate);

	CreditCardStatement saveStatement(CreditCardStatement statement);

}
