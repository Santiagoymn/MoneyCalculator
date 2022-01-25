package View;

import Control.ControlClass;
import Model.Currency;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class DialogSwing extends JPanel implements Dialog{
    private JComboBox originCurrencyComboBox;
    private JComboBox destinationCurrencyComboBox;
    private JTextField amount;
    private JButton uploadCurrencyFileButton;
    
    private JPanel originCurrencyPanel;
    private JPanel DestinationCurrencyPanel;
    private JPanel panelCoins;
    private JPanel currencyButtonPanel;
    
    private JPanel panel;
    
    private final ControlClass control;
     
    
    public DialogSwing(ControlClass control){   
        this.control = control;
        initComponents();  
        addAction();
    }
    
    private void initComponents(){
        createCoinPanel();
        createCurrencyButtonPanel();
        createPanel();
    }
    
    private void createPanel(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        panel.add(panelCoins);
        panel.add(currencyButtonPanel);
    }
    
      
    private void createCoinPanel(){
        originCurrencyPanel = new JPanel();
        originCurrencyPanel.setLayout(new FlowLayout(0));
        originCurrencyPanel.add(new JLabel("Moneda de origen"));
        originCurrencyComboBox = new JComboBox();   
        originCurrencyPanel.add(originCurrencyComboBox);
        
        originCurrencyPanel.add(new JLabel("Cantidad"));
        amount = new JTextField(7);
        amount.setText("1.0");
        originCurrencyPanel.add(amount);
   
        DestinationCurrencyPanel = new JPanel();
        DestinationCurrencyPanel.setLayout(new FlowLayout(0));
        DestinationCurrencyPanel.add(new JLabel("Moneda de destino"));
        destinationCurrencyComboBox = new JComboBox();
        DestinationCurrencyPanel.add(destinationCurrencyComboBox);
    
        panelCoins = new JPanel();
        panelCoins.setLayout(new BoxLayout(panelCoins, BoxLayout.PAGE_AXIS));
        panelCoins.add(originCurrencyPanel);
        panelCoins.add(DestinationCurrencyPanel);
    }
    
    private void createCurrencyButtonPanel(){
        currencyButtonPanel = new JPanel();
        currencyButtonPanel.setLayout(new FlowLayout(0));
        uploadCurrencyFileButton = new JButton("Cargar divisas de archivo");
        
        currencyButtonPanel.add(uploadCurrencyFileButton);
    }
    
    public JPanel returnDialogo(){
        return panel;
    }
    
    
    @Override
    public void setJComboBox(List<Currency>listCurrencies){
        destinationCurrencyComboBox.removeAllItems();
        destinationCurrencyComboBox.removeAllItems();
        for(int i=0; i<listCurrencies.size(); i++){
            originCurrencyComboBox.addItem(listCurrencies.get(i));
            destinationCurrencyComboBox.addItem(listCurrencies.get(i));
        }
        destinationCurrencyComboBox.setSelectedIndex(1);
    } 

    @Override
    public Currency getCurrencyTo(){
        return (Currency) destinationCurrencyComboBox.getSelectedItem();
    }
       
    
    @Override
    public Currency getCurrencyFrom(){
        return (Currency) originCurrencyComboBox.getSelectedItem();
    }
    
    @Override
    public double getAmount(){
        String a = amount.getText();
        if (a.contains(",")){
            a = a.replace(",",".");
        }
        return Double.parseDouble(a);
    }
    
    private void addAction(){
        uploadCurrencyFileButton.addActionListener((ActionEvent arg0) -> {
            control.actionButton();
        });
        
        originCurrencyComboBox.addActionListener((ActionEvent arg0) -> {
            control.actionOriginCurrency();
        });
       
        destinationCurrencyComboBox.addActionListener((ActionEvent arg0) -> {
            control.actionDestinationCurrency();
        });
        
        control.setJTexFieldChanged(amount);
    }
}
