/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectzbiorksiazekteams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48514
 */
public class Wyszukiwarka implements IWyszukiwarka {

    private BazaKsiazke bazaKsiazke;

    public Wyszukiwarka(BazaKsiazke bazaKsiazke) {
        this.bazaKsiazke = bazaKsiazke;
    }

    @Override

    public List<Ksiazka> wyszukiwarkaPoTytule(String tytul) {
        List<Ksiazka> wynik = new ArrayList<>();
        for (Ksiazka x : bazaKsiazke.getKsiazki()) {
            if (x.getTytul().toLowerCase().contains(tytul.toLowerCase())) {
                wynik.add(x);
            }
        }
        return wynik;
    }

    @Override
    public List<Ksiazka> wyszukiwarkaPoAutorze(String autor) {
        List<Ksiazka> wynik = new ArrayList<>();
        for (Ksiazka x : bazaKsiazke.getKsiazki()) {
            if (x.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                wynik.add(x);
            }
        }
        return wynik;
    }

    @Override
    public List<Ksiazka> wyszukiwarkaPoRoku(int rokWydania) {
        List<Ksiazka> wynik = new ArrayList<>();
        for (Ksiazka x : bazaKsiazke.getKsiazki()) {
            if (x.getRokWydania() == rokWydania) {
                wynik.add(x);
            }
        }
        return wynik;
    }

}
