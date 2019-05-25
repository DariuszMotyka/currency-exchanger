package pl.sda.dm.currencyexchanger.exchanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.dm.currencyexchanger.model.Currency;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class NbpExchangeRateDownloader {

    private RestTemplate restTemplate;

    @Autowired
    public NbpExchangeRateDownloader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NbpExchangeResult download(LocalDate date, Currency currency){
        Map<String, String> params = new HashMap<>();
        params.put("table", "A");
        params.put("code", currency.name());
        params.put("date", date.toString());

        NbpExchangeRateSeries result = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{date}", NbpExchangeRateSeries.class, params);


        return new NbpExchangeResult(result.getRates().get(0).getMid());

    }
}
