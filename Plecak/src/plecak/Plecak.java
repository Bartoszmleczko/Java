/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plecak;

/**
 *
 * @author Bartosz
 */
public class Plecak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              
   int plecak = 10;          
 
    int[] V = {6, 2, 3, 2, 3, 1};  
    int[] W = {6, 4, 5, 7, 10, 2}; 

    
         int maxW = 0;
        int v, w;
        int i, j, k, m, n, p;
        int[] tab = new int[6]; 
        for (i = 0; i <= 1; i++) {
            for (j = 0; j <= 1; j++) {
                for (k = 0; k <= 1; k++) {
                    for (m = 0; m <= 1;m++) {
                        for (n = 0; n <= 1;n++) {
                            for (p = 0; p <= 1; p++) {
                                v = i * V[0] + j * V[1] + k * V[2]
                                        + m * V[3] + n * V[4] + p * V[5];
                                if (v <= plecak) {
                                    w = i * W[0] + j * W[1] +k * W[2]
                                            + m * W[3] + n * W[4] + p * W[5];
                                    if (w > maxW) {
                                        maxW = w;
                                        tab[0] = i;
                                        tab[1] = j;
                                        tab[2] = k;
                                        tab[3] = m;
                                        tab[4] = n;
                                        tab[5] = p;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
 
        System.out.println("Wartosc przedmiotów w plecaku, to:  " + maxW);
        System.out.println("W plecaku są przedmioty o numerach :  ");
        for (int r = 0; r < 6; r++) {
            if (tab[r] == 1) {
                System.out.print(r + " ");
            }
        }

    }}
    

