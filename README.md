2. Napisz aplikację konsolową w języku Java maven, która zarządza zbiorami 
książek w bibliotece. Aplikacja powinna umożliwiać dodawanie, usuwanie, 
wyszukiwanie książek oraz wypożyczanie i zwracanie książek. Przy tworzeniu 
funkcjonalności programu użyj odpowiednich interfejsów. Pamiętaj o zasadzie
pojedynczej odpowiedzialności.
Dodawanie książek:
• Użytkownik podaje informacje o książce (tytuł, autor, rok wydania, ISBN) i 
dodaje ją do systemu.
• Wszystkie pola są obowiązkowe i powinny posiadać walidację:
o tytuł – 100 znaków
o autor – 100 – 50 znaków
o rok wydania - 4-cyfry
o ISBN - 13-cyfr
• Jeżeli książka o danym numerze ISBN istnieje w bibliotece, program zwiększa 
jej ilość o 1.
Usuwanie książek:
• Użytkownik podaje ISBN książki do usunięcia z systemu.
• Jeżeli podany ISBN nie istnieje, program powinien podać taką informację.
• Jeżeli w bibliotece znajduje się więcej niż jedna książka o podanym numerze 
ISBN, program zmniejsza jej ilość o 1. 
• Jeżeli ilość wynosi 0, książka jest usuwana z biblioteki.
Wyszukiwanie książek:
• Wyszukiwanie książek według różnych kryteriów (tytuł, autor, rok wydania).
• Program zwraca wszystkie książki spełniające kryterium (wyświetlenie na 
ekranie).
Wypożyczanie i zwracanie książek:
• Użytkownik wypożycza książkę, podając jej ISBN. Program sprawdza czy na 
stanie jest wystarczająca liczba książek do wypożyczenia.
• Użytkownik zwraca książkę, podając jej ISBN. Program sprawdza czy książka o 
podanym numerze ISBN jest wypożyczona i może być zwrócona.
Wyświetlanie wszystkich książek:
• Lista wszystkich książek dostępnych w bibliotece z informacją o ilości oraz 
informacji
