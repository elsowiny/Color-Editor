/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.coloreditor;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author Sherief
 * @author Carter
 */
public class View implements ActionListener, ViewInterface {   
    ModelInterface model;
    ControllerInterface controller;
    
    int redValue = 0;
    int blueValue = 0;
    int greenValue = 0;
    int hexValue = 0;
    
    JPanel panel1;
    JPanel panel2;
    JPanel container;
    JPanel color;
    JPanel colorBorder;
    
    JLabel labelRed;
    JLabel labelGreen;
    JLabel labelBlue;
    
    JTextField redValueTextField;
    JTextField greenValueTextField;
    JTextField blueValueTextField;
    JTextField hexValueTextField;
    
    JButton redPlusTen;
    JButton redMinusTen;
    JButton greenPlusTen;
    JButton greenMinusTen;
    JButton bluePlusTen;
    JButton blueMinusTen;
    
    public View(ModelInterface model, ControllerInterface controller) {
        this.model = model;
        this.controller = controller;
    }
    
    public void createView() {
        //Buttons
        redPlusTen = new JButton("+10");
        redMinusTen = new JButton("-10");
        greenPlusTen = new JButton("+10");
        greenMinusTen = new JButton("-10");
        bluePlusTen = new JButton("+10");
        blueMinusTen = new JButton("-10");
        
        //Labels
        labelRed = LabelFactory.createLabel("Red");
        //labelRed = new JLabel("Red");
        labelGreen = LabelFactory.createLabel("Green");
        //labelGreen = new JLabel("Green");
        labelBlue = LabelFactory.createLabel("Blue");
        //labelBlue = new JLabel("Blue");
        
        //Text Fields
        redValueTextField = new JTextField("0");
        greenValueTextField = new JTextField("0");
        blueValueTextField = new JTextField("0");
        hexValueTextField = new JTextField("Hex: #000000");
        hexValueTextField.setHorizontalAlignment(JTextField.CENTER);
        hexValueTextField.setEditable(false);
        
        //Panels
        container = new JPanel();
        container.setLayout(new GridLayout(1,2));
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0, 2));
        panel1.add(labelRed);
        panel1.add(redPlusTen);
        panel1.add(redValueTextField);
        panel1.add(redMinusTen);
        panel1.add(labelGreen);
        panel1.add(greenPlusTen);
        panel1.add(greenValueTextField);
        panel1.add(greenMinusTen);
        panel1.add(labelBlue);
        panel1.add(bluePlusTen);
        panel1.add(blueValueTextField);
        panel1.add(blueMinusTen);
        /*
         * 	Color c = model.getColor();
        String hex = Integer.toHexString(c.getRGB() & 0xffffff);
        view.hexValueTextField.setText("Hex: #" + hex);
        view.color.setBackground(Color.decode("#" + view.hexValueTextField.getText().substring(6)));
         */
        color = new JPanel();
        color.setBackground(Color.decode("#" + hexValueTextField.getText().substring(6)));
        
        BorderLayout bl = new BorderLayout();
        colorBorder = new JPanel(bl);
        //color.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        colorBorder.add(color, BorderLayout.CENTER);
        colorBorder.setBorder(BorderFactory.createEmptyBorder(30, 25, 30, 25));
        
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(0, 1));
        panel2.add(colorBorder);
        panel2.add(hexValueTextField);     
        
        container.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        container.add(panel1);
        container.add(panel2);

        //Frame
        JFrame frame = new JFrame();
        frame.add(container, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }
    
    public void createControls() {
        //Action Listeners
        redPlusTen.addActionListener(this);
        redMinusTen.addActionListener(this);
        greenPlusTen.addActionListener(this);
        greenMinusTen.addActionListener(this);
        bluePlusTen.addActionListener(this);
        blueMinusTen.addActionListener(this);
        redValueTextField.addActionListener(this);
        greenValueTextField.addActionListener(this);
        blueValueTextField.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        //Button action listeners
        if (e.getSource() == redPlusTen) {
            controller.plusTen("red");
        }
        else if (e.getSource() == redMinusTen) {
            controller.minusTen("red");
        }
        if (e.getSource() == greenPlusTen) {
            controller.plusTen("green");
        }
        else if (e.getSource() == greenMinusTen) {
            controller.minusTen("green");
        }
        if (e.getSource() == bluePlusTen) {
            controller.plusTen("blue");
        }
        else if (e.getSource() == blueMinusTen) {
            controller.minusTen("blue");
        }
        //Text Field action listeners
        else if (e.getSource() == redValueTextField) {
            controller.textFieldChanged("red");
        }
        else if (e.getSource() == greenValueTextField) {
            controller.textFieldChanged("green");
        }
        else if (e.getSource() == blueValueTextField) {
            controller.textFieldChanged("blue");
        }
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}
    
}
