/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;


import java.util.HashMap;
import java.util.Random;


public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // zgadnij(7);    
        // System.out.println(plecak());
        

    }

    
   
    
    
    
    public static int plecak() {
        int value[] = {6, 4, 5, 7, 10, 2};
        int weight[] = {6, 2, 3, 2, 3, 1};
        int TotalW = 10;
        int Wynik[][] = new int[value.length + 1][TotalW + 1];
        for (int i = 0; i <= value.length; i++) {
            for (int j = 0; j <= TotalW; j++) {
                if (i == 0 || j == 0) {
                    Wynik[i][j] = 0;
                    continue;
                }
                if (j - weight[i - 1] >= 0) {
                    Wynik[i][j] = Math.max(Wynik[i - 1][j], Wynik[i - 1][j - weight[i - 1]] + value[i - 1]);

                } else {
                    Wynik[i][j] = Wynik[i - 1][j];
                }
            }
        }
        return Wynik[value.length][TotalW];
    }

    public static void zgadnij(int x) { // Zgadywanie liczby Dziel i Zwyciężaj
        int p = 0, k = 1000;
        Random r = new Random();
        int kroki = 1;

        int y;

        do {

            System.out.println("Zakres szukania liczby: " + p + " - " + k);

            y = r.nextInt(k - p) + p;
            System.out.println("Czy jest to liczba " + y + "?");
            if (y == x) {
                System.out.println("TAK!");
                System.out.println("Liczba kroków: " + kroki);
                break;

            }

            if (y > x) {
                System.out.println("Wprowadzona liczba jest za duża");

                System.out.println("--------------------------------");

                k = y;
                kroki++;

            }

            if (y < x) {
                System.out.println("Wprowadzona liczba jest za mała");
                System.out.println("--------------------------------");
                p = y;
                kroki++;
            }
        } while (true);

    }

}