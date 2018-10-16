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
import sun.security.x509.X500Name;

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

                JOptionPane.showMessageDialog(null, "Wpisano");
            }
        }
        );

        JButton confirmButton = new JButton("Dodaj element");
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
                int sizeOfList = listModel.getSize();
               /* int toDelete = 0;
                String text = textField.getText();
                if(listModel.get(0).equals(text)){
                    listModel.remove(0);
                    listModel.setSize(-1);
                }
                else{
               for(int i=1; i<=sizeOfList; i++){
                        if(listModel.get(i).equals(text)){
                            listModel.remove(i);
                            listModel.setSize(listModel.getSize()-1);
                        }}
                }*/
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
        countryList.setVisible(true);
    }

}
