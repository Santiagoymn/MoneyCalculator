package Persistence;

import Model.Currency;
import Model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate get(Currency from, Currency to);
}
