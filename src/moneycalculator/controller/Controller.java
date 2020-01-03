package moneycalculator.controller;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;
import moneycalculator.model.ExchangeRate;
import moneycalculator.view.MoneyCalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private MoneyCalculatorView frame;
    private RESTExchangeRateLoader loader;

    public Controller(MoneyCalculatorView MoneyCalculatorView) {
        this.frame = MoneyCalculatorView;
    }


    public void initialize() {
        loader = new RESTExchangeRateLoader();
        frame.setCurrencySet(new CurrencyList().getList());
        frame.initialize();
        JButton button = (JButton)frame.getMyComponents().get("CalculateButton");
        JComboBox toCurrency = (JComboBox)frame.getMyComponents().get("SelectorTo");
        JTextField amountField = (JTextField)frame.getMyComponents().get("Amount");
        JTextField resultArea = (JTextField)frame.getMyComponents().get("Result");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExchangeRate er = loader.load((Currency)toCurrency.getSelectedItem());
                Double amount = Double.parseDouble(amountField.getText());
                Double result = amount * er.getRate();
                resultArea.setText(result.toString());
            }
        });
    }
}