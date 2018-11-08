/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_gui;

/**
 *
 * @author Bartosz
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Lab_GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Moja formatka!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 40));
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        
        label.setDisplayedMnemonic(KeyEvent.VK_N);
        
        
        
        JTextField textField = new JTextField(" ", 15);
        textField.setHorizontalAlignment(JTextField.LEFT);
        Container ContentPane = frame.getContentPane();
        

        DefaultListModel<String> listModel = new DefaultListModel<>();      
        JList countryList = new JList<>(listModel);

        textField.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(textField.getText());
                textField.setText("");
            }
        }
        );
            
        //zad5
       
     
     
        JButton confirmButton = new JButton("Dodaj element");                   //zad 2-4 zdarzenia
        confirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = countryList.getSelectedIndex();
                if(index==-1){
                listModel.addElement(textField.getText());
                index++;
                }
                else{
                    listModel.add(countryList.getSelectedIndex()+1, "");
                    listModel.setElementAt(textField.getText(),countryList.getSelectedIndex()+1 );
                    index++;
                }
                textField.setText("");
                
            }
        });
        
        JButton replaceButton = new JButton("Zamień element");
        replaceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = countryList.getSelectedIndex();
                if(index==-1){
                listModel.setElementAt(textField.getText(),0 );
                index++;
                }
                else{
                    
                    listModel.setElementAt(textField.getText(),index );
                    index++;
                }
                textField.setText("");
                
            }
        });
        
        JButton removeButton = new JButton("Usuń element");
        removeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedindex = countryList.getSelectedIndex();
                if(countryList.getSelectedIndex()<=0){
                listModel.removeElementAt(0);
                }
                else{
                   listModel.removeElementAt(countryList.getSelectedIndex()); 
                }
                
            }
        });
        

        JButton findAndRemoveButton= new JButton("Usuń element o tej treści");
       findAndRemoveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeElement(textField.getText());
                textField.setText("");
                
            }
        }) ;
       
       
   
        
        label.setLabelFor(textField);
        panel.add(label);
        panel.add(textField);
        frame.add(panel);
        
        ContentPane.add(confirmButton);
        ContentPane.add(removeButton);
        ContentPane.add(replaceButton);
        ContentPane.add(findAndRemoveButton);
        
        frame.add(new JScrollPane(countryList));
        frame.setSize(400, 350);
        frame.setVisible(true);

        countryList.setSize(200, 200);
        countryList.setVisible(true);

       // zad6 zad = new zad6();
        //zad.start();
        
       // Zad6Slider zad6s = new Zad6Slider();
       // zad6s.start();
        
        //Zad8 zad8 = new Zad8();
        //zad8.start();
        
        //Zad9 zad9 = new Zad9();
     // zad9.start();
        
        Zad10 zad10 = new Zad10();
       zad10.start();
    }

}
