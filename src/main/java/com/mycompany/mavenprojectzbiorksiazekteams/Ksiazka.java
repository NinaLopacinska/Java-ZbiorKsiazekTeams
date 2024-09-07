/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectzbiorksiazekteams;

/**
 *
 * @author 48514
 */
public class Ksiazka {
    private String tytul;
    private String autor;
    private int rokWydania;
    private String ISBN;
    private boolean wypozyczenie;
    private int ilosc;
    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

     public void zwiekszIlosc() {
        this.ilosc++;
    }

    public void zmniejszIlosc() {
        if (this.ilosc > 0) {
            this.ilosc--;
        }
    }

    
     public boolean isWypozyczenie() { 
        return wypozyczenie;
    }

    public void setWypozyczenie(boolean wypozyczenie) {  
        this.wypozyczenie = wypozyczenie;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

}
