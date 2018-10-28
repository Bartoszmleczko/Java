/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aisd2;
import java.util.*;
/**
 *
 * @author Bartosz
 */
public class Aisd2 {


    
    public static void main(String[] args) {
        Random random = new Random();
        int stala = random.nextInt(1000);
        Scanner sc = new Scanner(System.in);
        
       /* System.out.println("Losuj liczbe");
        int los= sc.nextInt();
        if(los==stala){
            System.out.println("brawo");
        }
        if(los<stala){
            System.out.println("za malo");
        }
        if(los>stala){
            System.out.println("Za duzo");
        }
        while(los!=stala){
            
           los = sc.nextInt(); 
                   if(los==stala){
            System.out.println("brawo");
        }
        if(los<stala){
            System.out.println("za malo");
        }
        if(los>stala){
            System.out.println("Za duzo");
        }
        }*/
        int wilk=0;
        int koza = 0;
        int kapusta = 0;
        
            for(int i=0; i<=1; i++){
                for(int j = 0; j<=1;j++){
                    for(int k =0; k<=1;k++){
                        System.out.println("Wilk: " + i + "  Koza: " + j + "   Kapusta:" + k );
                    }
                }
            }
        }
        
    
    
}
