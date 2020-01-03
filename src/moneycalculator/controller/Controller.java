package moneycalculator.controller;

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
        //loader = new RESTExchangeRateLoader();
        //frame.setCurrencySet(new FileCurrencySetLoader().loadCurrencies());
        frame.initialize();
        //JButton button = (JButton)frame.getMyComponents().get("Button");
//
        //button.addActionListener(new ActionListener() {
        //    @Override
        //    public void actionPerformed(ActionEvent actionEvent) {
        //       // commands.get("calculate").execute();
        //    }
        //});
    }
}