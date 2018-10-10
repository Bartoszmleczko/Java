/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progob;

import progob1.Mechanik;
import progob1.Murarz;
import progob1.Nauczyciel;
import progob1.Osoba;
import progob1.Piekarz;
import progob1.Pracownik;

/**
 *
 * @author Bartosz
 */
public class ProgOb1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Osoba osoby[]= new Pracownik[100];
        int i=0;
        while(i<100){
            osoby[i]= new Murarz("murarz" , "Jan" , "Kowalski", 20);
            osoby[i+1]= new Nauczyciel("nauczyciel", "Janina", "Kowalska",30);
            osoby[i+2]= new Mechanik("Mechanik" , "Jan" , "Kowalski", 20);
            osoby[i+3]= new Piekarz("piekarz", "Janina", "Kowalska",30);
            i=i+4;
             }
        for(int j=0;j<100;j++){
            
            System.out.println(j + ". " +osoby[j].PokazDane());
        }
    }
    
}
