package moneycalculator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //ArrayList<Currency> currencies = new ArrayList<>();
        //currencies.add(new Currency("USD", "Dolar Americano", "$"));
        //currencies.add(new Currency("EUR", "Euro", "€"));

        CSVCurrencyCreator creator = new CSVCurrencyCreator(new File("").getAbsolutePath() + "/src/moneycalculator/currency.csv");
        List<Currency> list = creator.create();
        for (Currency currency : list) {

            System.out.println(currency);
        }

        ExchangeRateLoader loader = new RESTExchangeRateLoader(list);
        ExchangeRate[] exchangeRates = loader.load();


        System.out.println("Exchange rates: " + Arrays.toString(exchangeRates));

        for (ExchangeRate er : exchangeRates) {
            Double divisaIntercambiado = 1000 * er.getRate();
            System.out.println("Por 1000 " + er.getFrom().getName() + " te da :" + divisaIntercambiado + er.getTo().getName());
        }
    }
}
