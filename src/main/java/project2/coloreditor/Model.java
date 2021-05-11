/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.coloreditor;

import java.awt.Color;

/**
 * @author Sherief
 * @author Carter
 */
public class Model implements ModelInterface {
    
	//rgb
	Color color = new Color(0, 0, 0);
	
	public Color getColor() {
		return color;
	}
	
	


	@Override
	public void updateColor(int redValue, int greenValue, int blueValue) {
		this.color = new Color(redValue, greenValue,blueValue);
		
	}

}
