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
/**
 *
 * @author Bartosz
 */
public class zad6 extends JFrame{
    private  JFrame frame = new JFrame("Zadanie 6");
    private String[] prod = {"jeden","dwa","trzy"};
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JTextField textField = new JTextField(10);
    private Container ContentPane = frame.getContentPane();
    private JButton addButton = new JButton("Dodaj element");
    private JButton removeButton = new JButton("Usun element");
    private JButton removeAllButton = new JButton("Usun cala liste");
    private JButton removeByContentButton = new JButton("Usun zawartosc");
     private JComboBox patternList = new JComboBox(prod);
     
     
    public zad6() {
    }


    
    
    public void start(){
        
            
        
             textField.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patternList.addItem(textField.getText());
                textField.setText("");
            }
        }
        );
             addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                patternList.insertItemAt(textField.getText(),patternList.getSelectedIndex()+1);
                textField.setText("");
                
            }
        }) ;
             
        removeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                patternList.removeItemAt(patternList.getSelectedIndex());
                textField.setText("");
                
            }
        }) ;
        
        removeAllButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                patternList.removeAllItems();
                patternList.addItem(prod);
                textField.setText("");
                
            }
        });
        
                removeByContentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                patternList.removeItem(textField.getText());
                textField.setText("");
                
            }
        });
        
        label.setDisplayedMnemonic(KeyEvent.VK_N);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 40));
        textField.setHorizontalAlignment(JTextField.LEFT);
        label.setLabelFor(textField);
        panel.add(label);
        panel.add(textField);
        frame.add(panel); 
        ContentPane.add(addButton);
        ContentPane.add(removeButton);
        ContentPane.add(removeAllButton);
        ContentPane.add(removeByContentButton);
        ContentPane.add(patternList, BorderLayout.CENTER);
        frame.setSize(400,350);
        frame.setVisible(true);
    }
}
