package com.udemy.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    //hhhhhhh

    @Autowired
    public CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
    {
        //CurrencyExchange currencyExchange = new CurrencyExchange(10000L, from, to, BigDecimal.valueOf(65));
         CurrencyExchange currencyExchange= currencyExchangeRepository.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
