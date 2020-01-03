package moneycalculator.controller;

import moneycalculator.model.Currency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVCurrencyCreator implements CurrencyCreator {

    private static Logger LOGGER = Logger.getLogger(CSVCurrencyCreator.class.getName());
    private final String filename;

    public CSVCurrencyCreator(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Currency> create() {
        return read(new ArrayList<>());
    }

    private List<Currency> read(List<Currency> list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                list.add(createCurrency(line));
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return null;
        }
        return list;
    }

    private Currency createCurrency(String line) {
        String[] split = line.split(",");
        return new Currency(split[0], split[1], split[2]);
    }

}

