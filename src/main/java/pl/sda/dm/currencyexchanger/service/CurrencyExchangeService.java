package pl.sda.dm.currencyexchanger.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dm.currencyexchanger.exchanger.NbpExchangeRateDownloader;
import pl.sda.dm.currencyexchanger.exchanger.NbpExchangeResult;
import pl.sda.dm.currencyexchanger.model.Currency;
import pl.sda.dm.currencyexchanger.model.ExchangeResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class CurrencyExchangeService {
    private NbpExchangeRateDownloader nbpExchangeRateDownloader;

    @Autowired
    public CurrencyExchangeService(NbpExchangeRateDownloader nbpExchangeRateDownloader) {
        this.nbpExchangeRateDownloader = nbpExchangeRateDownloader;
    }

    public ExchangeResult calculate(LocalDate date, BigDecimal value, String currency){
        NbpExchangeResult rateResult = nbpExchangeRateDownloader.download(date, Currency.valueOf(currency));
        BigDecimal result = value.divide(rateResult.getRate(),2, RoundingMode.HALF_DOWN);
        ExchangeResult exchangeResult = new ExchangeResult();
        exchangeResult.setResult(result);
        return exchangeResult;
    }
}
