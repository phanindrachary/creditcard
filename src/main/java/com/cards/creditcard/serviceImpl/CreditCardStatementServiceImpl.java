package com.cards.creditcard.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cards.creditcard.model.CreditCardStatement;
import com.cards.creditcard.repository.CreditCardStatementRepository;
import com.cards.creditcard.service.CreditCardStatementService;

@Service
public class CreditCardStatementServiceImpl implements CreditCardStatementService{
	
    @Autowired
    private CreditCardStatementRepository repository;

	@Override
	public List<CreditCardStatement> getStatements(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public CreditCardStatement saveStatement(CreditCardStatement statement) {
		// TODO Auto-generated method stub
		return  repository.save(statement);
	}

}
