package moneycalculator;

import com.google.gson.Gson;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RESTExchangeRateLoader implements ExchangeRateLoader {

    private List<Currency> currencies;

    public RESTExchangeRateLoader(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public ExchangeRate[] load() {
        try {

            URL url = new URL("https://api.exchangeratesapi.io/latest");
            Scanner api = new Scanner(url.openStream());
            String responseText = api.nextLine();

            Gson gson = new Gson();
            //System.out.println("Response text: " + responseText);
            ExchangeRateResponse response = gson.fromJson(responseText, ExchangeRateResponse.class);
            String baseCode = response.getBase();
            Currency baseCurrency = null;

            for (Currency currency : this.currencies) {
                if (currency.getCode().equals(baseCode)) {
                    baseCurrency = currency;
                    break;
                }
            }

            if (baseCurrency == null) {
                return new ExchangeRate[0];
            }

            List<ExchangeRate> results = new ArrayList<>();

            for (Map.Entry<String, Double> entry : response.getRates().entrySet()) {
                Currency toCurrency = null;
                for (Currency currency : this.currencies) {
                    if (currency.getCode().equals(entry.getKey())) {
                        toCurrency = currency;
                        break;
                    }
                }
                if (toCurrency != null) {
                    ExchangeRate er = new ExchangeRate(entry.getValue(), response.getDate(), baseCurrency, toCurrency);
                    results.add(er);
                }
            }

            return results.toArray(new ExchangeRate[results.size()]);

        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return null;
    }
}
