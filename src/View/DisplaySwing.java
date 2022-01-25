package View;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class DisplaySwing extends JPanel implements Display{

    private JTextPane resultArea;
    private JPanel resultPane;
 
    
    public DisplaySwing(){
        initComponents();
    }
    
    private void initComponents(){
        resultPane = new JPanel();
        resultPane.setLayout(new BoxLayout(resultPane, BoxLayout.PAGE_AXIS));
        
        resultArea = new JTextPane();
        resultArea.setEditable(false);
        
        StyledDocument doc = resultArea.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        
        resultPane.add(resultArea);    
    }
    
    @Override
    public JPanel returnDisplay(){
        return resultPane;
    } 
    
    @Override
    public void refreshArea(String amount){
        resultArea.setText(amount);
    } 
}
    
    
    
