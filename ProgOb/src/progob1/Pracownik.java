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
public abstract class Pracownik extends Osoba{

    private String zawod;

    public Pracownik(String zawod, String imie, String nazwisko, int wiek) {
        super(imie, nazwisko, wiek);
        this.zawod = zawod;
    }

    @Override
    public String PokazDane() {
        return "Pracownik{" +super.PokazDane()+ "zawod=" + zawod + '}';
    }

    public abstract String WykonajPrace();

    @Override
    public abstract String Mow();

}
