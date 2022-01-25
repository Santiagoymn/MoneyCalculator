package moneycalculator;

import Control.ControlClass;
import Persistence.Archive.CurrencyLoaderArchive;
import Persistence.WebService.ExchangeRateLoaderWebService;
import View.DialogDisplayFrame;

public class MoneyCalculator {
    
   
    public static void main(String[] args) {
                
        CurrencyLoaderArchive currencyLoader = new CurrencyLoaderArchive("currencies.txt") {};
        ExchangeRateLoaderWebService exchangeRateLoaderWebService = new ExchangeRateLoaderWebService();
        
        ControlClass control = new ControlClass(currencyLoader, exchangeRateLoaderWebService);
        DialogDisplayFrame dialogoDisplay = new DialogDisplayFrame(control);
        control.setDialogDisplayFrame(dialogoDisplay);
        
    } 
}
