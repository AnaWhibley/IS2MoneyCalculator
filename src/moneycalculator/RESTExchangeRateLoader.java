package moneycalculator;

import com.google.gson.Gson;

import java.net.URL;
import java.util.Scanner;

public class RESTExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate[] load() {
        try {

            URL url = new URL("https://api.exchangeratesapi.io/latest");
            Scanner api = new Scanner(url.openStream());
            String e = api.nextLine();

            Gson gson = new Gson();
            System.out.println("111" + e);
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return null;
    }
}
