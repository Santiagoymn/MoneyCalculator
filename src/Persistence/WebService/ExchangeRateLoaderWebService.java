package Persistence.WebService;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExchangeRateLoaderWebService implements ExchangeRateLoader {
    private BufferedReader in;
    private URL aux;
    
    @Override
    public ExchangeRate get(Currency from, Currency to){
        try {
            String codigoMonedaOrigen = from.getCode().substring(0, from.getCode().length()).toLowerCase();
            String codigoMonedaDestino = to.getCode().substring(0, to.getCode().length()).toLowerCase();
            
            aux = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + codigoMonedaOrigen + "/" + codigoMonedaDestino + ".json");
        } catch (MalformedURLException ex) {
            return null;
        }
        
        String inputLine;
        ExchangeRate res = null;
        try {
            in = new BufferedReader(new InputStreamReader(aux.openStream()));
        } catch(IOException t){}
        
        int i=0;
        try {
            while ((inputLine = in.readLine()) != null) {
                if (i == 2){
                    inputLine = inputLine.trim();
                    inputLine = inputLine.substring(6, inputLine.length());
       
                    res = new ExchangeRate(Double.parseDouble(inputLine),from,to);
                    i++;
                    break;
                }
                i++;          
            }
        } catch (IOException ex) {
            Logger.getLogger(ExchangeRateLoaderWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
