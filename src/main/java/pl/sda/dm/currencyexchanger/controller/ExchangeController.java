package pl.sda.dm.currencyexchanger.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.dm.currencyexchanger.model.Currency;
import pl.sda.dm.currencyexchanger.model.ExchangeResult;
import pl.sda.dm.currencyexchanger.service.CurrencyExchangeService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class ExchangeController {

    private CurrencyExchangeService currencyExchangeService;

    @Autowired
    public ExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @RequestMapping("exchange/{value}/{date}/{currency}")
    public ResponseEntity<ExchangeResult> getExchangeValue(@PathVariable(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exchangeDate,
                                                           @PathVariable(name = "value") BigDecimal value,
                                                           @PathVariable(name = "currency") String currency) {
        return new ResponseEntity<>(currencyExchangeService.calculate(exchangeDate, value, currency), HttpStatus.OK);
    }

    @RequestMapping("currency")
    public Currency[] getCurrencyTypes(){
        return Currency.values();
    }
}
