package com.cards.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cards.creditcard.model.CreditCardStatement;

@EnableJpaRepositories
public interface CreditCardStatementRepository extends JpaRepository<CreditCardStatement, Long> {

}
