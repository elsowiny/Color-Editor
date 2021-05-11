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
public class Controller implements ControllerInterface {
    ModelInterface model;
    View view;
    
    public Controller(ModelInterface model) {
        this.model = model;
        view = new View(model, this);
        view.createView();
        view.createControls();
    }
    
    public void updateColor() {
    	//gets current color from the model and updates view
       // Color c = new Color(red, green, blue);
    	Color c = model.getColor();
        String hex = Integer.toHexString(c.getRGB() & 0xffffff);
        view.hexValueTextField.setText("Hex: #" + hex);
        view.color.setBackground(Color.decode("#" + view.hexValueTextField.getText().substring(6)));
        
      //  Color newColor = model.getColor();
    }
    
    public void plusTen(String color) {
        if (color.equals("red")) {
            if (view.redValueTextField.getText().equals("")) {
                view.redValue = 0;
            }
            else
                view.redValue = Integer.parseInt(view.redValueTextField.getText());
            
            if (view.redValue <= 245) {
                view.redValue += 10;
                view.redValueTextField.setText("" + view.redValue);
            }
            else {
                view.hexValueTextField.setText("RGB values out of range");
                return;
            }
        }
        else if (color.equals("green")) {
            if (view.greenValueTextField.getText().equals("")) {
                view.greenValue = 0;
            }
            else
                view.greenValue = Integer.parseInt(view.greenValueTextField.getText());
            
            if (view.greenValue <= 245) {
                view.greenValue += 10;
                view.greenValueTextField.setText("" + view.greenValue);
            }
            else {
                view.hexValueTextField.setText("RGB values out of range");
                return;
            }
        }
        else if (color.equals("blue")) {
            if (view.blueValueTextField.getText().equals("")) {
                view.blueValue = 0;
            }
            else
                view.blueValue = Integer.parseInt(view.blueValueTextField.getText());
            
            if (view.blueValue <= 245) {
                view.blueValue += 10;
                view.blueValueTextField.setText("" + view.blueValue);
            }
            else {
                view.hexValueTextField.setText("RGB values out of range");
                return;
            }
        }
        model.updateColor(view.redValue, view.greenValue, view.blueValue);
        updateColor();
    }
    
    public void minusTen(String color) {
        if (color.equals("red")) {
            if (view.redValueTextField.getText().equals("")) {
                view.redValue = 0;
                view.redValueTextField.setText("0");
            }
            else
                view.redValue = Integer.parseInt(view.redValueTextField.getText());
            
            if (view.redValue >= 10) {
                view.redValue -= 10;
                view.redValueTextField.setText("" + view.redValue);
            }
            else {
                view.hexValueTextField.setText("RGB values out of range");
                return;
            }
        }
        else if (color.equals("green")) {
            if (view.greenValueTextField.getText().equals("")) {
                view.greenValue = 0;
                view.greenValueTextField.setText("0");
            }
            else
                view.greenValue = Integer.parseInt(view.greenValueTextField.getText());
            
            if (view.greenValue >= 10) {
                view.greenValue -= 10;
                view.greenValueTextField.setText("" + view.greenValue);
            }
            else {
                view.hexValueTextField.setText("RGB values out of range");
                return;
            }
        }
        else if (color.equals("blue")) {
            if (view.blueValueTextField.getText().equals("")) {
                view.blueValue = 0;
                view.blueValueTextField.setText("0");
            }
            else
                view.blueValue = Integer.parseInt(view.blueValueTextField.getText());
            
            if (view.blueValue >= 10) {
                view.blueValue -= 10;
                view.blueValueTextField.setText("" + view.blueValue);
            }
            else {
                view.hexValueTextField.setText("RGB values out of range");
                return;
            }
        }
        
        model.updateColor(view.redValue, view.greenValue, view.blueValue);
        updateColor();
    }
    
    public void textFieldChanged(String color) { 
        if (color.equals("red")) {
            int tempRedValue = Integer.parseInt(view.redValueTextField.getText());
            if (tempRedValue >=0 && tempRedValue <= 255) {
                view.redValue = tempRedValue;
                model.updateColor(view.redValue, view.greenValue, view.blueValue);
                updateColor();
            }
            else {
                view.redValueTextField.setText(String.valueOf(view.redValue));
                view.hexValueTextField.setText("RGB values out of range");
            }
        }
        else if (color.equals("green")) {
            int tempGreenValue = Integer.parseInt(view.greenValueTextField.getText());
            if (tempGreenValue >=0 && tempGreenValue <= 255) {
                view.greenValue = tempGreenValue;
                model.updateColor(view.redValue, view.greenValue, view.blueValue);
                updateColor();
            }
            else {
                view.greenValueTextField.setText(String.valueOf(view.greenValue));
                view.hexValueTextField.setText("RGB values out of range");
            }
        }
        else if (color.equals("blue")) {
            int tempBlueValue = Integer.parseInt(view.blueValueTextField.getText());
            if (tempBlueValue >=0 && tempBlueValue <= 255) {
                view.blueValue = tempBlueValue;
                model.updateColor(view.redValue, view.greenValue, view.blueValue);
                updateColor();	
            }
            else {
                view.blueValueTextField.setText(String.valueOf(view.blueValue));
                view.hexValueTextField.setText("RGB values out of range");
            }
        }
    }
    
}
