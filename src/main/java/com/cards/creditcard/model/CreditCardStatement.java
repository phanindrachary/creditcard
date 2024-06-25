package com.cards.creditcard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class CreditCardStatement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String cardNumber;

	@NonNull
	private LocalDate startDate;

	@NonNull
	private LocalDate endDate;

	@NonNull
	private double amount;
	
	

	public CreditCardStatement() {
		super();
	}

	public CreditCardStatement(Long id, @NonNull String cardNumber, @NonNull LocalDate startDate,
			@NonNull LocalDate endDate, @NonNull double amount) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
