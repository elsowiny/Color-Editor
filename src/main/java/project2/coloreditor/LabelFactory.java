package project2.coloreditor;

import javax.swing.JLabel;

public class LabelFactory {
	  JLabel labelRed;
	    JLabel labelGreen;
	    JLabel labelBlue;
	    
	    public static JLabel createLabel(String label) {
	    	return new JLabel(label);
	    }

}
