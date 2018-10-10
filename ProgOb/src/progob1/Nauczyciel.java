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
public class Nauczyciel extends Pracownik{
       public Nauczyciel(String zawod, String imie, String nazwisko, int wiek) {
        super(zawod, imie, nazwisko, wiek);
    }


    public String WykonajPrace() {
        return "Ucz";
    }
    @Override
    public String Mow(){
        return "Ucze";
    }
        @Override
    public String PokazDane() {
        return "Pracownik{" + super.PokazDane()+" "+Mow() + " "+WykonajPrace();
}}
