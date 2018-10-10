/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progob1;



/**
 *
 * @author Bartosz
 */
public class Murarz extends Pracownik{

    public Murarz(String zawod, String imie, String nazwisko, int wiek) {
        super(zawod, imie, nazwisko, wiek);
    }

   
   
    @Override
    public String WykonajPrace() {
        return "Muruj";
    }
    @Override
    public String Mow(){
        return "Muruje";
    }
        @Override
    public String PokazDane() {
        return "Pracownik: " + super.PokazDane()+" "+Mow() + " "+WykonajPrace();
        
        
    }
    
}
