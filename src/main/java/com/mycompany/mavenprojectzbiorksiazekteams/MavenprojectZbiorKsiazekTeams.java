/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenprojectzbiorksiazekteams;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author 48514
 */
public class MavenprojectZbiorKsiazekTeams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BazaKsiazke bazaKsiazke = new BazaKsiazke();
        IWyszukiwarka wyszukiwarka = new Wyszukiwarka(bazaKsiazke);

        System.out.println("Program do zarzadzania biblioteka");

        boolean czyWyjsc = false;
        do {
            System.out.println("1. Dodaj nowa ksiazke");
            System.out.println("2. Usun ksiazke");
            System.out.println("3. Wyszukaj ksiazke");
            System.out.println("4. Wypozycz/Zwroc ksiazke ");
            System.out.println("5. Wyswietl wszystkie ksiazki ");
            System.out.println("6. Zakoncz program");

            int nrOpcji = scanner.nextInt();
            //if (scanner.hasNextInt()) {

            switch (nrOpcji) {
                case 1:

                    boolean poprawna1 = false;
                    scanner.nextLine();
                    String tytul;
                    do {
                        System.out.println("Podaj tytul ksiazki: ");
                        tytul = scanner.nextLine();
                        if (tytul.equals("") || tytul.length() > 100) {
                            System.out.println("Podaj poprawny tytul.");
                        } else {
                            poprawna1 = true;
                        }
                    } while (!poprawna1);

                    boolean poprawna2 = false;
                    String autor;
                    do {
                        System.out.println("Podaj autora ksiazki: ");
                        autor = scanner.nextLine();
                        if (autor.equals("") || autor.length() < 50 || autor.length() > 100) {
                            System.out.println("Podaj poprawne nazwisko.");
                        } else {
                            poprawna2 = true;
                        }
                    } while (!poprawna2);

                    boolean poprawna4 = false;
                    int rokWydania;
                    do {
                        System.out.println("Podaj rok wydania ksiazki: ");
                        rokWydania = scanner.nextInt();
                        if (rokWydania < 1900 || rokWydania > 2024) {
                            System.out.println("Podaj poprawny rok.");
                        } else {
                            poprawna4 = true;
                        }
                    } while (!poprawna4);

                    boolean poprawna5 = false;
                    scanner.nextLine();
                    String isbn;
                    do {
                        System.out.println("Podaj ISBN ksiazki (13 cyfr): ");
                        isbn = scanner.nextLine();
                        if (isbn.length() != 13) {
                            System.out.println("Podaj poprawny isbn (13 cyfr).");
                        } else {
                            poprawna5 = true;
                        }
                    } while (!poprawna5);

                    Ksiazka ksiazka = new Ksiazka();

                    ksiazka.setTytul(tytul);
                    ksiazka.setAutor(autor);
                    ksiazka.setRokWydania(rokWydania);
                    ksiazka.setISBN(isbn);
                    ksiazka.setIlosc(1);

                    // sparwdzenie czy ISBN jest unikalny 
                    boolean czyUnikalne = true;

                    for (Ksiazka x : bazaKsiazke.getKsiazki()) {
                        if (x.getISBN().equalsIgnoreCase(ksiazka.getISBN())) {
                            x.zwiekszIlosc();
                            czyUnikalne = false;
                            break;
                        }
                    }
                    if (czyUnikalne) {
                        bazaKsiazke.getKsiazki().add(ksiazka);
                        System.out.println("Ksiazka zosal pomyslnie dodana.");
                    } else {

                        System.out.println("Ksiazka o takim ISBN juz istnieje. Zwiekszamy jej islosc. ");
                    }

                    break;

                case 2:
                    scanner.nextLine();
                    System.out.println("Podaj ISBN ksiazki, ktora chcesz usunac: ");
                    String isbnDoUsuniecia = scanner.nextLine();
                    boolean znalezion = false;

                    for (Ksiazka x : bazaKsiazke.getKsiazki()) {
                        if (x.getISBN().equals(isbnDoUsuniecia)) {
                            znalezion = true;
                            if (x.getIlosc() > 1) {
                                x.zmniejszIlosc();
                                System.out.println("Znaleziono ksiazke o podanym ISBN i zmniejszono jej ilosc o 1: " + x.getTytul());
                            }

                        } else {
                            bazaKsiazke.getKsiazki().remove(x);
                            System.out.println("Usunieto ksiazke o podanym ISBN.");
                        }
                    }
                    if (!znalezion) {
                        System.out.println("Nie znaloziono ksiazki o podanym ISBN: " + isbnDoUsuniecia);
                    }
                    break;

                case 3:
                    boolean wyszukuje = true;
                    do {
                        System.out.println("Po czym chcesz wyszukac ksiazke?");
                        System.out.println("1. Tytul");
                        System.out.println("2. Autor");
                        System.out.println("3. Rok wydania");
                        System.out.println("4. Zakoncz wyszukiwanie");

                        int nrWyszukania;
                        nrWyszukania = scanner.nextInt();
                        scanner.nextLine();
                        switch (nrWyszukania) {
                            case 1:
                                System.out.println("Podaj tytul ksiazki: ");
                                String tytulW = scanner.nextLine();
                                List<Ksiazka> znalezioneTytuly = wyszukiwarka.wyszukiwarkaPoTytule(tytulW);
                                wyswietlWyniki(znalezioneTytuly);
                                break;
                            case 2:
                                System.out.println("Podaj autora ksiazki: ");
                                String autorW = scanner.nextLine();
                                List<Ksiazka> znalezieniAutorzy = wyszukiwarka.wyszukiwarkaPoAutorze(autorW);
                                wyswietlWyniki(znalezieniAutorzy);
                                break;
                            case 3:
                                System.out.println("Podaj rok wydania ksiazk:");
                                int rokWydaniaW = scanner.nextInt();
                                List<Ksiazka> znalezionyRok = wyszukiwarka.wyszukiwarkaPoRoku(rokWydaniaW);
                                wyswietlWyniki(znalezionyRok);
                                break;
                            case 4:
                                System.out.println("Do kolejnego wyszukiwania.");
                                wyszukuje = false;
                                break;
                            default:
                                System.out.println("Nieprawidlowa opcjia.");
                        }
                    } while (!wyszukuje);
                    break;
                case 4:
                    int czynnosc;
                    System.out.println("Wypozycz ksiazke -1, zwroc ksiazke -2.");
                    czynnosc = scanner.nextInt();
                    scanner.nextLine();

                    if (czynnosc == 1) {
                        System.out.print("Podaj tytuł ksiazki do wypozyczenia: ");
                        String tytulWypozycz = scanner.nextLine();
                        Ksiazka ksiazkaDoWypozyczenia = znajdzKsiazkePoTytule(bazaKsiazke, tytulWypozycz);
                        if (ksiazkaDoWypozyczenia != null) {
                            if (ksiazkaDoWypozyczenia.getIlosc() > 0) {  // Sprawdzamy, czy są dostępne egzemplarze
                                ksiazkaDoWypozyczenia.zmniejszIlosc();  // Zmniejszamy ilość dostępnych egzemplarzy
                                System.out.println("Książka '" + ksiazkaDoWypozyczenia.getTytul() + "' została wypożyczona.");
                            } else {
                                System.out.println("Brak dostępnych egzemplarzy książki '" + ksiazkaDoWypozyczenia.getTytul() + "'.");
                            }
                        } else {
                            System.out.println("Nie znaleziono książki o takim tytule.");
                        }
                    } else if (czynnosc == 2) {  // Zwracanie książki
                        System.out.print("Podaj tytuł książki do zwrotu: ");
                        String tytulZwrot = scanner.nextLine();
                        Ksiazka ksiazkaDoZwrotu = znajdzKsiazkePoTytule(bazaKsiazke, tytulZwrot);

                        if (ksiazkaDoZwrotu != null) {
                            ksiazkaDoZwrotu.zwiekszIlosc();  // Zwiększamy ilość dostępnych egzemplarzy
                            System.out.println("Książka '" + ksiazkaDoZwrotu.getTytul() + "' została zwrócona.");
                        } else {
                            System.out.println("Nie znaleziono książki o takim tytule.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Lista ksiazke:");
                    for (Ksiazka x : bazaKsiazke.getKsiazki()) {
                        System.out.println("Ksiazka o tytule:  " + x.getTytul() + " autorstwa: " + x.getAutor() + " wydana w roku " + x.getRokWydania() + " ilosc: " + x.getIlosc());
                    }
                    break;

                case 6:
                    System.out.println("Zapraszamy ponownie!");
                    czyWyjsc = true;
                    break;
                default:
                    throw new AssertionError();
            }

        } while (!czyWyjsc);
    }

    private static void wyswietlWyniki(List<Ksiazka> ksiazki) {
        if (ksiazki.isEmpty()) {
            System.out.println("Brak wynikow");
        } else {
            for (Ksiazka x : ksiazki) {
                System.out.println("Znalezione ksiazki to: " + x.getTytul() + " autorstwa " + x.getAutor() + " z roku " + x.getRokWydania());
            }
        }
    }

    private static Ksiazka znajdzKsiazkePoTytule(BazaKsiazke bazaKsiazke, String tytul) {
        for (Ksiazka ksiazka : bazaKsiazke.getKsiazki()) {
            if (ksiazka.getTytul().equalsIgnoreCase(tytul)) {
                return ksiazka;
            }
        }
        return null;
    }
}
