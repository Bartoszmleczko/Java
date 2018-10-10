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
public class Mechanik extends Pracownik{
       public Mechanik(String zawod, String imie, String nazwisko, int wiek) {
        super(zawod, imie, nazwisko, wiek);
    }

  
   public String WykonajPrace() {
        return "Naprawiaj auta";
    }
    @Override
    public String Mow(){
        return "Naprawiam auta";
    }
        @Override
    public String PokazDane() {
        return "Pracownik{" + super.PokazDane()+" "+Mow() + " "+WykonajPrace();
}
    }
