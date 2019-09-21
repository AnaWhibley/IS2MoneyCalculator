package moneycalculator;

import java.io.File;
import java.util.ArrayList;
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

        ExchangeRateLoader loader = new RESTExchangeRateLoader();
        loader.load();


    }
}
