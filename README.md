# README #

Projekt Labo Menager

### Ustawienie środowiska: ###

* tworzymy pustą bazę danych w MySQL o nazwie "pwr_labo"
* dokonujemy zmian w pliku /labo/src/main/resources/application.properties jeśli chcemy łączyć się za pomocą innych credentiali bazodanowych (parametry app.jdbc.username i app.jdbc.password)
* odpalamy aplikację z klasy Controller w celu stworzenia się struktury DB
* zamykamy aplikację
* odpalamy skrypt /sql/icd.sql
* po kolejnym odpaleniu aplikacji, powinna być używalna normalnie