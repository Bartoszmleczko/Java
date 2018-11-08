/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author Bartosz
 */
public class Zad8 extends JFrame{
     private  JFrame frame = new JFrame("Zadanie 8");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private Container ContentPane1 = frame.getContentPane();
BoxLayout boxLayout = new BoxLayout(ContentPane1, BoxLayout.Y_AXIS);
    private JPanel mpan = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 40));
    private JPanel mpan1 = new JPanel();
    private JPanel mpan2 = new JPanel();
    private JPanel mpan3 = new JPanel();

    private JPanel pan1 = new JPanel();
    private JPanel pan2 = new JPanel();
    private JPanel pan3 = new JPanel();
    
    private JButton but1 = new JButton("Przycisk 1");
    private JButton but2 = new JButton("Przycisk 2");
    private JButton but3 = new JButton("Przycisk 3");
    
    private JTextField text1 = new JTextField(10);
    private JTextField text2 = new JTextField(10);
    private JTextField text3 = new JTextField(10);
    
    private JCheckBox check1 = new JCheckBox("Panel 1");
    private JCheckBox check2 = new JCheckBox("Panel 2");
    private JCheckBox check3 = new JCheckBox("Panel 3");
    
    public Zad8() {
    }
    

    public void start(){
        check1.setSelected(true);
        check2.setSelected(true);
        check3.setSelected(true);
        
        BoxLayout boxLayout = new BoxLayout(mpan1, BoxLayout.Y_AXIS);

        pan1.setBorder(BorderFactory.createLineBorder(Color.black));
        pan1.setSize(200,50);
     
        
        pan2.setBorder(BorderFactory.createLineBorder(Color.black));
        pan2.setSize(200,50);

   
        pan3.setBorder(BorderFactory.createLineBorder(Color.black));
        pan3.setSize(200,50);

 
        pan1.add(text1);
        pan1.add(but1); 
        pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
        pan2.add(text2);
        pan2.add(but2);
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
        pan3.add(text3);
        pan3.add(but3);
        pan3.setLayout(new BoxLayout(pan3, BoxLayout.Y_AXIS));
        mpan1.add(pan1);
        mpan1.add(check1);
        mpan1.setLayout(new BoxLayout(mpan1, BoxLayout.Y_AXIS));
        mpan2.add(pan2);
        mpan2.add(check2);
        mpan2.setLayout(new BoxLayout(mpan2, BoxLayout.Y_AXIS));
        mpan3.add(pan3);
        mpan3.add(check3);
        mpan3.setLayout(new BoxLayout(mpan3, BoxLayout.Y_AXIS));
        mpan.add(mpan1);
        mpan.add(mpan2);
        mpan.add(mpan3);
        check1.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                                if(check1.isSelected()){
                    pan1.setVisible(true);
                }
                else{
                    pan1.setVisible(false);
                }
            }
        });
        check2.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                                if(check2.isSelected()){
                    pan2.setVisible(true);
                }
                else{
                    pan2.setVisible(false);
                }
            }
        });
        
        check3.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                                if(check3.isSelected()){
                    pan3.setVisible(true);
                }
                else{
                    pan3.setVisible(false);
                }
            }
        });
        

        label.setDisplayedMnemonic(KeyEvent.VK_N);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 40));
        
        frame.add(mpan);


        frame.setSize(650,500);
        frame.setVisible(true);
    }
}
