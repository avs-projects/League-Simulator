package gui.main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
 
public class MyImageButton extends JButton {
 
    private static final long serialVersionUID = 1L;
    
    private String name;
 
    public MyImageButton(String icon, String name) {
    	
    	this.name = name;
    	
        Icon img = new ImageIcon(this.getClass().getResource(icon));
    	
        setBackground(new Color(67, 31, 114));
        
        setFocusPainted(false);
        
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        
        setIcon(img);
         
    }
    
    public String getTeamName() {
    	return name;
    }
}