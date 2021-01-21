## MeteoApplication 
MeteoApplication è il frutto del lavoro svolto per l'appello di Programmazione ad oggetti di gennaio 2020/2021.
Usufruendo dei dati ricavati dall'API di Openweather, l'applicazione restituisce informazioni attuali e genera statistiche periodiche relative alle temperature  di diverse città.
## Autori 
* Gioele Pasquini 50%
* Umberto Maraglino 50%
## Istruzioni per l'uso
* Strumenti necessari
1) IDE Java;
2) Software per la comunicazione col client (Es. Postman).
* Avvio applicazione 
1) Download della cartella col codice da github;
2) Importare la cartella sull'IDE;
3) Aggiungere nella sezione "Build Path" l'external jar "java-json.jar" (scaricabile dal seguente [link](http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm));
4) Avviare l'applicazione come SpringBootApplication;
5) Inserire la rotta su Postman.
## UML
![UML](https://github.com/GioelePasquini/project.java/blob/main/IMG/UML%20base.png)
Questo UML rappresenta il funzionamento della nostra applicazione.
L'utente può:
1) Visualizzare le informazioni attuali sulla temperatura grazie all'API OpenWeather;
2) Visualizzare statistiche sulla temperature di informazioni presenti nello storico;
3) Visualizzare statistiche periodiche di informazioni presenti nello storico.

**N.B** I dati vengono trattati in gradi Kelvin.

**N.B** Lo storico presenta i dati delle città "Rome" e "London" per un periodo che va dal 01-12-2020 al 15-12-2020.

## Rotte
La comunicazione tra utente ed appliczione avviene tramite l'utilizzo di rotte predefinite.
Di seguito è riportata una tabella riassuntiva.



1)
Tipo | Path | 
---- | ---- | 
GET | localhost:8080/temp/{names} |;

La seguente rotta restituisce all'utente le informazioni attuali relative alla temperatura di una o più città.

**N.B.** {names} può contenere uno o più nomi. Nel caso contenga più nomi, questi devono essere divisi da ","

Esempio rotta: 

"localhost:8080/temp/Ancona,Bologna"

Risposta:

![temp](https://github.com/GioelePasquini/project.java/blob/main/IMG/rispostatemp.PNG)



2)
Tipo | Path | 
---- | ---- | 
POST | localhost:8080/stats |;

Fornisce all'utente statistiche riguardanti:

* temperatura media;
* varianza tra temperatura reale e percepita;
* entrambe.

relative alle città scelte.

La rotta richiede un Request body con il seguente formato:

![body_stats](https://github.com/GioelePasquini/project.java/blob/main/IMG/stats_body.PNG)

L'utente dovrà sostituire 
* "citta" con il nome delle città (**N.B.** le città devono essere separate da virgole senza spazi); 
* "first_day" con il giorno da cui si vuole la statistica;
* "last_day" con il giorno fino a cui si vuole la statistica;
* "type_stat" con il tipo di statistica che si vuole visualizzare (**N.B** inserire "*Media*", "*Varianza*" o "*All*").


3)
Tipo | Path | 
---- | ---- | 
POST | localhost:8080/limit/{type_temp}/{type_rel}/{limit} |;

Fornisce i giorni in cui il tipo di temperatura è maggiore o minore del limite, relativi alle città scelte.

La rotta richiede un Request body con il seguente formato:

![body_limit](https://github.com/GioelePasquini/project.java/blob/main/IMG/limit_body.PNG)

L'utente dovrà sostituire 

* {type_temp} con il tipo di temperatura da visualizzare ("*temp*", "*temp_max*", "*temp_min*" o "*feels_like*");
* {type_rel} con ""*maggiore*" o "*minore*";
* {limit} con il limite numerico;
* "citta" con il nome delle città (**N.B.** le città devono essere separate da virgole senza spazi); 
* "first_day" con il giorno da cui si vuole verificare;
* "last_day" con il giorno fino a cui si vuole verificare.

Esempio rotta: 

"localhost:8080/limit/temp_min/maggiore/275"

Risposta applicando il filtro mostrato precedentemente:

![risposta_limit](https://github.com/GioelePasquini/project.java/blob/main/IMG/limit_risposta.PNG)


4)

Tipo | Path | 
---- | ---- | 
POST | localhost:8080/rangingfrom/{type_temp}/{limitinf}/{limitsup} |;

Fornisce i giorni in cui il tipo di temperatura è compreso tra il limite inf e il limite sup, relativi alle città scelte.

La rotta richiede un Request body con il seguente formato:

![body_rf](https://github.com/GioelePasquini/project.java/blob/main/IMG/rangingfrom_body.PNG)

L'utente dovrà sostituire 

* {type_temp} con il tipo di temperatura da visualizzare ("*temp*", "*temp_max*", "*temp_min*" o "*feels_like*");
* {limitinf} con il limite numerico inferiore;
* {limitsup} con il limite numerico superiore;
* "citta" con il nome delle città (**N.B.** le città devono essere separate da virgole senza spazi); 
* "first_day" con il giorno da cui si vuole verificare;
* "last_day" con il giorno fino a cui si vuole verificare.

Esempio rotta: 

"localhost:8080/rangingfrom/temp_min/265/270"

Risposta applicando il filtro mostrato precedentemente:

![risposta_rf](https://github.com/GioelePasquini/project.java/blob/main/IMG/ranging_risposta.PNG)


5)
Tipo | Path | 
---- | ---- | 
POST | localhost:8080/periodically|;

Fornisce statistiche periodiche.

La rotta richiede un Request body con il seguente formato:

![body_periodically](https://github.com/GioelePasquini/project.java/blob/main/IMG/weekly_body.PNG)

L'utente dovrà sostituire 

* "citta" con il nome delle città (**N.B.** le città devono essere separate da virgole senza spazi); 
* "type_stat" con il tipo di statistica che si vuole visualizzare (**N.B** inserire "*Media*", "*Varianza*" o "*All*").
* "range" con "*Weekly*" per statistiche settimanali, "*Daily*" per statistiche giornaliere o "*Customizable*" per statistiche con range personalizzabie;
* "num_gg" con un numero compreso tra 1 e 15 (**N.B.** questo campo deve essere inserito solo se "range" è "*Customizable*".

Esempio rotta: 

"localhost:8080/periodically"

Risposta applicando il filtro mostrato precedentemente:

![risposta_peiodically](https://github.com/GioelePasquini/project.java/blob/main/IMG/weekly_risposta.PNG)




