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

public class Zad10 {
     private  JFrame frame = new JFrame("Zadanie 10");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private Container ContentPane1 = frame.getContentPane();
BoxLayout boxLayout = new BoxLayout(ContentPane1, BoxLayout.Y_AXIS);
    private JPanel mpan = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 40));

    
     private JPanel pan1 = new JPanel();
    private JPanel pan2 = new JPanel();
    private JPanel pan3 = new JPanel();
    
    private JButton but1 = new JButton("Przycisk 1");
    private JButton but2 = new JButton("Przycisk 2");
    private JButton but3 = new JButton("Przycisk 3");
    
    private JTextField text1 = new JTextField(10);
    private JTextField text2 = new JTextField(10);
    private JTextField text3 = new JTextField(10);
    
    private JMenuBar bar = new JMenuBar();
    private JMenu menuitems = new JMenu("Menu");
    private JMenuItem show1 = new JMenu("Panel 1");
    private JMenuItem show2 = new JMenu("Panel 2");
    private JMenuItem show3 = new JMenu("Panel 3");
    
    public void start(){
       
         
      menuitems.add(show1);
            menuitems.addSeparator();
      menuitems.add(show2);
            menuitems.addSeparator();
      menuitems.add(show3);
      bar.add(menuitems);    

         pan1.setBorder(BorderFactory.createLineBorder(Color.black));
        pan1.setSize(200,50);
        pan1.setVisible(false);
        
        pan2.setBorder(BorderFactory.createLineBorder(Color.black));
        pan2.setSize(200,50);
pan2.setVisible(false);
   
        pan3.setBorder(BorderFactory.createLineBorder(Color.black));
        pan3.setSize(200,50);
pan3.setVisible(false);
 


        show2.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              pan1.setVisible(true);
          }
            
        });

        pan1.add(text1);
        pan1.add(but1); 
        pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
        pan2.add(text2);
        pan2.add(but2);
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
        pan3.add(text3);
        pan3.add(but3);
        pan3.setLayout(new BoxLayout(pan3, BoxLayout.Y_AXIS));
         mpan.add(pan1);
        mpan.add(pan2);
        mpan.add(pan3);
         label.setDisplayedMnemonic(KeyEvent.VK_N);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 40));
        
        
        frame.setJMenuBar(bar);
        frame.add(mpan);

        
        frame.setSize(650,500);
        frame.setVisible(true);
    }







    
}
