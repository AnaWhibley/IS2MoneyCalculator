package moneycalculator;

import java.util.Date;

public class ExchangeRate {
    private final double rate;
    private final Date date;
    private final Currency from;
    private final Currency to;

    public ExchangeRate(double rate, Date date, Currency from, Currency to) {
        this.rate = rate;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public double getRate() {
        return rate;
    }

    public Date getDate() {
        return date;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }
}
