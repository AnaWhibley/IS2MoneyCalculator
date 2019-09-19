package moneycalculator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("USD", "Dolar Americano", "$"));
        currencies.add(new Currency("EUR", "Euro", "€"));

    }
}
