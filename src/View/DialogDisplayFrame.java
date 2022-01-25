package View;

import Control.ControlClass;
import Model.Currency;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DialogDisplayFrame extends JPanel implements DialogDisplay{
    
    private JFrame frame;
    private final DialogSwing dialogSwing;
    private final DisplaySwing displaySwing;
    private final ControlClass control;
    
    
    public DialogDisplayFrame(ControlClass control){     
        this.control = control;
        
        dialogSwing = new DialogSwing(control);
        displaySwing = new DisplaySwing();
     
        initComponents();
                      
        frame.setLocation(220,300);
        frame.setSize(350, 180);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void pack(){
        frame.pack();
    }
    
    private void initComponents(){
        frame = new JFrame();
        frame.setTitle("Money Calculator");
    
        Container panel = frame.getContentPane();
        panel.setLayout(new BorderLayout());
        
        JPanel dialogo = dialogSwing.returnDialogo();
        JPanel display = displaySwing.returnDisplay();
            
        panel.add(dialogo, BorderLayout.NORTH);
        panel.add(display, BorderLayout.CENTER);
    }
    
    
    @Override
    public void refreshArea(String aux){
        displaySwing.refreshArea(aux);
    }
    
    @Override
    public void setJComboBox(List<Currency>listCurrencies){
        dialogSwing.setJComboBox(listCurrencies);
    }
    
    
    @Override
    public Currency getCurrencyTo(){
        return dialogSwing.getCurrencyTo();
    }
    
    @Override
    public Currency getCurrencyFrom(){
        return dialogSwing.getCurrencyFrom();
    }
     
    @Override
    public double getAmount(){
        return dialogSwing.getAmount();
    }
}
