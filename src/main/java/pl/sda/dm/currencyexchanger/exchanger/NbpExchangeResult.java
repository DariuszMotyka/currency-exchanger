package pl.sda.dm.currencyexchanger.exchanger;

import java.math.BigDecimal;

public class NbpExchangeResult {

    private BigDecimal rate;

    public NbpExchangeResult(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "NbpExchangeResult{" +
                "rate=" + rate +
                '}';
    }
}

