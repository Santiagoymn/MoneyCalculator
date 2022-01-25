package View;

import Model.Currency;
import java.util.List;

public interface DialogDisplay {
    public void refreshArea(String aux);
    public void setJComboBox(List<Currency>listCurrencies);
    public Currency getCurrencyFrom();
    public Currency getCurrencyTo();
    public double getAmount();
}
