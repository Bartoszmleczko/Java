/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Bartosz
 */
public class Zad6Slider {
    
    static final int FPS_MIN = 0;
    static final int FPS_MAX = 255;
    static final int FPS_INIT = 0;
    
    private  JFrame frame = new JFrame("Zadanie 6");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JLabel redLabel = new JLabel("Czerwony: 0");
    private JLabel blueLabel = new JLabel("Niebieski: 0");
    private JLabel greenLabel = new JLabel("Zielony: 0");
    private Container ContentPane = frame.getContentPane();
    
    private JSlider redSlider = new JSlider(FPS_MIN, FPS_MAX, FPS_INIT);
    private JSlider greenSlider = new JSlider(FPS_MIN, FPS_MAX, FPS_INIT);
    private JSlider blueSlider = new JSlider(FPS_MIN, FPS_MAX, FPS_INIT);
    public Zad6Slider() {
    }
    
    public void start(){
        
        
        
        redSlider.addChangeListener(new ChangeListener() {
            @Override
      public void stateChanged(ChangeEvent e) {
          redLabel.setText("Czerwony: " + redSlider.getValue());
         frame.getContentPane().setBackground(new java.awt.Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
      }
    });
        
                greenSlider.addChangeListener(new ChangeListener() {
            @Override
      public void stateChanged(ChangeEvent e) {
          greenLabel.setText("Niebieski: " + greenSlider.getValue());
          frame.getContentPane().setBackground(new java.awt.Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
      }
    });
                        blueSlider.addChangeListener(new ChangeListener() {
            @Override
      public void stateChanged(ChangeEvent e) {
          blueLabel.setText("Zielony: " + blueSlider.getValue());
          frame.getContentPane().setBackground(new java.awt.Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
      }
    });
        
        
        
        
        
        
        
        
        
        redLabel.add(redSlider);
        greenLabel.add(greenSlider);
        blueLabel.add(blueSlider);
        redSlider.setBounds(50, 50, 300, 50);
        label.setDisplayedMnemonic(KeyEvent.VK_N);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 40));
        frame.add(redLabel);
        frame.add(redSlider);
        frame.add(greenLabel);
        frame.add(greenSlider);
        frame.add(blueLabel);
        frame.add(blueSlider);
        frame.setSize(400,350);
        frame.setVisible(true);
    }
}
