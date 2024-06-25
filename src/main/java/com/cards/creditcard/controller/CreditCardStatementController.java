package com.cards.creditcard.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cards.creditcard.model.CreditCardStatement;
import com.cards.creditcard.service.CreditCardStatementService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/creditcard/api")
public class CreditCardStatementController {
    @Autowired
    private CreditCardStatementService service;

    @GetMapping("/getstatements")
    public List<CreditCardStatement> getStatements(@RequestParam("start") String start,
                                                   @RequestParam("end") String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return service.getStatements(startDate, endDate);
    }

    @PostMapping("/savestatement")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardStatement createStatement(@RequestBody CreditCardStatement statement) {
        return service.saveStatement(statement);
    }
}

