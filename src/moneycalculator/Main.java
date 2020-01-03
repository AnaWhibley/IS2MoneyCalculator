package moneycalculator;

import moneycalculator.controller.CSVCurrencyCreator;
import moneycalculator.controller.ExchangeRateLoader;
import moneycalculator.controller.RESTExchangeRateLoader;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.view.MoneyCalculatorView;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //ArrayList<Currency> currencies = new ArrayList<>();
        //currencies.add(new Currency("USD", "Dolar Americano", "$"));
        //currencies.add(new Currency("EUR", "Euro", "€"));

        //ExchangeRateLoader loader = new RESTExchangeRateLoader(list);
        //ExchangeRate[] exchangeRates = loader.load();
//
//
        ////System.out.println("Exchange rates: " + Arrays.toString(exchangeRates));
//
        //for (ExchangeRate er : exchangeRates) {
        //    Double divisaIntercambiado = 1000 * er.getRate();
        //    System.out.println("Por 1000 " + er.getFrom().getName() + " te da :" + divisaIntercambiado + " " + er.getTo().getName());
        //}


        MoneyCalculatorView mainFrame = new MoneyCalculatorView("Money Calculator");
        //Controller controller = new Controller(mainFrame);
        //controller.initialize();
    }
}
