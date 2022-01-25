package Control;

import Model.Currency;
import Model.Money;
import Persistence.Archive.CurrencyLoaderArchive;
import Persistence.WebService.ExchangeRateLoaderWebService;
import View.DialogDisplayFrame;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ControlClass {
    
    private final ExchangeRateLoaderWebService exchangeRateLoaderWebService;
    private final CurrencyLoaderArchive currencyLoader;
    private DialogDisplayFrame dialogoDisplay;
    
    public ControlClass(CurrencyLoaderArchive currencyLoader, ExchangeRateLoaderWebService exchangeRateLoaderWebService){       
        this.currencyLoader = currencyLoader;
        this.exchangeRateLoaderWebService = exchangeRateLoaderWebService;                           
    }
    
    public void setDialogDisplayFrame(DialogDisplayFrame dialogoDisplay){
        this.dialogoDisplay = dialogoDisplay;
    }
    
    public void actionButton(){
        List<Currency> listCurrencies = currencyLoader.loadAllCurrencies();
        dialogoDisplay.setJComboBox(listCurrencies);
        dialogoDisplay.pack();
        refreshDisplay();
    }
    
    public void actionOriginCurrency(){
        refreshDisplay();
    }
    
    public void actionDestinationCurrency(){
        refreshDisplay();
    }
    
     
    private Money getMoneyTo(){
        return new Money(getRate() * dialogoDisplay.getAmount(), 
                dialogoDisplay.getCurrencyTo());
    }
    
    private String getRateUnit(){
        return "\n\n1.0 " + dialogoDisplay.getCurrencyFrom().getCode() + " = " +
                getRate() + " " + dialogoDisplay.getCurrencyTo().getCode();
    }
    
    private double getRate(){
        return exchangeRateLoaderWebService.get(dialogoDisplay.getCurrencyFrom(), 
                dialogoDisplay.getCurrencyTo()).getRate();
    }
     
    public void setJTexFieldChanged(JTextField textField) {
        DocumentListener documentListener;
        documentListener = new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }
        };
        textField.getDocument().addDocumentListener(documentListener);
    }
 
    private void printIt(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();
 
        if (type.equals(DocumentEvent.EventType.CHANGE)) {
        }
        else if (type.equals(DocumentEvent.EventType.INSERT)) {
            refreshDisplay();
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE)) {
            refreshDisplay();
        }
    }
    
    private void refreshDisplay(){
        try{
            dialogoDisplay.refreshArea(String.valueOf(getMoneyTo().toString()) +
                getRateUnit());
        }catch(NumberFormatException exc){
            dialogoDisplay.refreshArea("Debe de ser un dígito númerico");
        }catch(Exception exc){
            dialogoDisplay.refreshArea("Error: "+ exc);
        }
    }
}
