package pl.sda.dm.currencyexchanger.exchanger;

import java.util.List;

public class NbpExchangeRateSeries {
    private String table;
    private String currency;
    private String code;
    private List<NbpExchangeRates> rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<NbpExchangeRates> getRates() {
        return rates;
    }
}
