/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenprojectzbiorksiazekteams;

import java.util.List;

/**
 *
 * @author 48514
 */
public interface IWyszukiwarka {
    List<Ksiazka> wyszukiwarkaPoTytule(String tytul);
    List<Ksiazka> wyszukiwarkaPoAutorze(String autor);
    List<Ksiazka> wyszukiwarkaPoRoku(int rokWydania);
}
