package gui.main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;
 
public class MyButton extends JButton {
 
    private static final long serialVersionUID = 1L;
 
    public MyButton(String txt) {
    	
        super(txt);
        setForeground(Color.WHITE);
        setBackground(new Color(60,60,60));
        
        setBorderPainted(false);
        setFocusPainted(false);
         
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.LEFT);
         
    }
}