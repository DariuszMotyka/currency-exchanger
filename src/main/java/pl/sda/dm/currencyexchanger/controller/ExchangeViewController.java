package pl.sda.dm.currencyexchanger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExchangeViewController {

    @GetMapping("/")
    public String getExchaneView(){
        return "index.html";
    }
}
