package pl.sda.dm.currencyexchanger.exchanger;

import java.math.BigDecimal;

public class NbpExchangeRates {
    private String no;
    private String effectiveDate;
    private BigDecimal mid;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }

}
