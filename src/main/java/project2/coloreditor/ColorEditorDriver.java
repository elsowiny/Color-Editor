/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.coloreditor;

/**
 * @author Sherief
 * @author Carter
 */
public class ColorEditorDriver {
    
    public static void main(String[] args) {
        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model);
    }
}
