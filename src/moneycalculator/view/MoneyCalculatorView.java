package moneycalculator.view;

import moneycalculator.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MoneyCalculatorView extends JFrame {
    private Map<String,JComponent> components = new LinkedHashMap<>();
    private List<Currency> currencies;

    public MoneyCalculatorView (String arg) {
        super(arg);
    }

    public void initialize () {

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        components.put("Title" , new JLabel("Calculate exchange from EUR to the currency you want"));
        components.get("Title").setFont(components.get("Title").getFont().deriveFont(1,18));
        Color color = Color.decode("#3574fc");
        components.get("Title").setForeground(color);

        components.put("AmountLabel", new JLabel("Insert an amount: "));
        components.put("Amount", new JTextField());
        components.get("Amount").setPreferredSize(new Dimension(100, 20));

        components.put("To", new JLabel("Select the currency: "));
        components.put("SelectorTo", new JComboBox<Currency>());

        components.put("CalculateButton", new JButton("Calculate"));

        components.put("ResultLabel", new JLabel("Result: "));
        components.put("Result", new JTextField());
        components.get("Result").setPreferredSize(new Dimension(160, 20));
        JTextField resultField = (JTextField)components.get("Result");
        resultField.setEditable(false);


        JComboBox<Currency> to = (JComboBox<Currency>) components.get("SelectorTo");
        for (Currency curr: currencies) {
            to.addItem(curr);
        }


        JPanel panelTop = new JPanel();
        JPanel panelMid = new JPanel();
        JPanel panelMid1 = new JPanel();
        JPanel panelMid2 = new JPanel();
        JPanel panelMid3 = new JPanel();
        JPanel panelBot = new JPanel();

        panelTop.add(components.get("Title"));
        panelTop.setLayout(new FlowLayout());

        panelMid1.add(components.get("AmountLabel"));
        panelMid1.add(components.get("Amount"));
        panelMid1.setLayout(new FlowLayout());

        panelMid2.add(components.get("To"));
        panelMid2.add(components.get("SelectorTo"));
        panelMid2.setLayout(new FlowLayout());

        panelMid3.add(components.get("ResultLabel"));
        panelMid3.add(components.get("Result"));
        panelMid3.setLayout(new FlowLayout());

        panelMid.add(panelMid1);
        panelMid.add(panelMid2);
        panelMid.add(panelMid3);
        panelMid.setLayout(new BoxLayout(panelMid, BoxLayout.Y_AXIS));

        panelBot.add(components.get("CalculateButton"));
        panelBot.setLayout(new FlowLayout());

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelMid, BorderLayout.CENTER);
        this.add(panelBot, BorderLayout.SOUTH);


        setSize(700, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void setCurrencySet (List<Currency> loadCurrencies) {
        this.currencies = loadCurrencies;
    }

    public Map<String, JComponent> getMyComponents() {
        return components;
    }
}
