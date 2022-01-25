package View;

import Model.Currency;
import java.util.List;


public interface Dialog {
    public Currency getCurrencyTo();
    public double getAmount();
    public Currency getCurrencyFrom();
    public void setJComboBox(List<Currency>listCurrencies);
}
