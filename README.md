## MeteoApplication 
MeteoApplication è il frutto del lavoro svolto per l'appello di Programmazione ad oggetti di gennaio 2020/2021.
Usufruendo dei dati ricavati dall'API Openweather, l'applicazione restituisce informazioni attuali e genera statistiche periodiche relative alle temperature  di diverse città.
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
5) Inserire una delle rotte su Postman.
## UML
![UML](https://github.com/GioelePasquini/project.java/blob/master/IMG/UML%20basejp.jpg)
Questo diagramma rappresenta il funzionamento della nostra applicazione.
L'utente può:
1) Visualizzare le informazioni attuali sulla temperatura grazie all'API OpenWeather;
2) Visualizzare statistiche sulla temperature di informazioni presenti nello storico;
3) Visualizzare statistiche periodiche di informazioni presenti nello storico.

**N.B** I dati vengono trattati in gradi Kelvin.

**N.B** Lo storico presenta i dati delle città "Rome" e "London" per un periodo che va dal 01-12-2020 al 15-12-2020.

## Rotte
La comunicazione tra utente ed applicazione avviene tramite l'utilizzo di rotte predefinite.
Di seguito sono riportate delle tabelle riassuntive con degli esempi.



1)
Tipo | Path | 
---- | ---- | 
GET | localhost:8080/temp/{names} |;

La seguente rotta restituisce all'utente le informazioni attuali relative alla temperatura di una o più città.

**N.B.** {names} può contenere uno o più nomi. Nel caso contenga più nomi, questi devono essere divisi da ",".

Esempio rotta: 

"localhost:8080/temp/Ancona,Bologna"

Risposta:

![temp](https://github.com/GioelePasquini/project.java/blob/main/IMG/rispostatemp.PNG)



2)
Tipo | Path | 
---- | ---- | 
POST | localhost:8080/stats |;

Fornisce all'utente statistiche (relative alle città scelte) riguardanti:

* temperatura media;
* varianza tra temperatura reale e percepita;
* entrambe.

La rotta richiede un Body con il seguente formato:

![body_stats](https://github.com/GioelePasquini/project.java/blob/main/IMG/stats_body.PNG)

L'utente dovrà sostituire 
* "citta" con il nome delle città presenti nello storico (**N.B.** le città devono essere separate da virgole senza spazi); 
* "first_day" con il giorno da cui si vuole la statistica (**N.B** stringa formato (gg-mm-aaaa));
* "last_day" con il giorno fino a cui si vuole la statistica (**N.B** stringa formato (gg-mm-aaaa));
* "type_stat" con il tipo di statistica che si vuole visualizzare (**N.B** inserire "*Media*", "*Varianza*" o "*All*").


3)
Tipo | Path | 
---- | ---- | 
POST | localhost:8080/limit/{type_temp}/{type_rel}/{limit} |;

Fornisce i giorni in cui il tipo di temperatura è maggiore o minore del limite, relativi alle città scelte.

La rotta richiede un Body con il seguente formato:

![body_limit](https://github.com/GioelePasquini/project.java/blob/main/IMG/limit_body.PNG)

L'utente dovrà sostituire 

* {type_temp} con il tipo di temperatura da visualizzare ("*temp*", "*temp_max*", "*temp_min*" o "*feels_like*");
* {type_rel} con ""*maggiore*" o "*minore*";
* {limit} con il limite numerico;
* "citta" con il nome delle città (**N.B.** le città devono essere separate da virgole senza spazi); 
* "first_day" con il giorno da cui si vuole verificare (**N.B** stringa formato (gg-mm-aaaa));
* "last_day" con il giorno fino a cui si vuole verificare (**N.B** stringa formato (gg-mm-aaaa)).

Esempio rotta: 

"localhost:8080/limit/temp_min/maggiore/275"

Risposta applicando il filtro mostrato precedentemente:

![risposta_limit](https://github.com/GioelePasquini/project.java/blob/main/IMG/limit_risposta.PNG)


4)

Tipo | Path | 
---- | ---- | 
POST | localhost:8080/rangingfrom/{type_temp}/{limitinf}/{limitsup} |;

Fornisce i giorni in cui il tipo di temperatura è compreso tra il limite inf e il limite sup, relativi alle città scelte.

La rotta richiede un Body con il seguente formato:

![body_rf](https://github.com/GioelePasquini/project.java/blob/main/IMG/rangingfrom_body.PNG)

L'utente dovrà sostituire 

* {type_temp} con il tipo di temperatura da visualizzare ("*temp*", "*temp_max*", "*temp_min*" o "*feels_like*");
* {limitinf} con il limite numerico inferiore;
* {limitsup} con il limite numerico superiore;
* "citta" con il nome delle città (**N.B.** le città devono essere separate da virgole senza spazi); 
* "first_day" con il giorno da cui si vuole verificare  (**N.B** stringa formato (gg-mm-aaaa));
* "last_day" con il giorno fino a cui si vuole verificare (**N.B** stringa formato (gg-mm-aaaa)).

Esempio rotta: 

"localhost:8080/rangingfrom/temp_min/265/270"

Risposta applicando il filtro mostrato precedentemente:

![risposta_rf](https://github.com/GioelePasquini/project.java/blob/main/IMG/ranging_risposta.PNG)


5)
Tipo | Path | 
---- | ---- | 
POST | localhost:8080/periodically|;

Fornisce statistiche periodiche.

La rotta richiede un Body con il seguente formato:

![body_periodically](https://github.com/GioelePasquini/project.java/blob/main/IMG/weekly_body.PNG)

L'utente dovrà sostituire 

* "citta" con il nome delle città (**N.B.** le città devono essere separate da virgole senza spazi); 
* "type_stat" con il tipo di statistica che si vuole visualizzare (**N.B** inserire "*Media*", "*Varianza*" o "*All*").
* "range" con "*Weekly*" per statistiche settimanali, "*Daily*" per statistiche giornaliere o "*Customizable*" per statistiche con range personalizzabie;
* "num_gg" con un numero compreso tra 1 e 15 (**N.B.** questo campo deve essere inserito solo se "range" è "*Customizable*".

Esempio rotta: 

"localhost:8080/periodically"

Risposta applicando il filtro mostrato precedentemente:

![risposta_periodically](https://github.com/GioelePasquini/project.java/blob/main/IMG/weekly_risposta.PNG)

Esempio di rotta con "*Custom*" :

Body inserito:

![body_custom](https://github.com/GioelePasquini/project.java/blob/main/IMG/custom_body.PNG)

Risposta:

![risposta_custom](https://github.com/GioelePasquini/project.java/blob/main/IMG/custom_risposta.PNG)

6)
Tipo | Path | 
---- | ---- | 
GET | localhost:8080/save/{name}/{num_iter}|;

Rotta che salva in un vector le informazioni riguardanti la temperatura di una città, ogni ora per un numero di volte scelto dall'utente.

L'utente dovrà sostituire 

* {name} con il nome di una città da monitorare;
* {num_iter} con il numero di ore per cui il programma monitora.

## Diagrammi delle classi

Di seguito sono riportati i diagrammi delle classi:

* Package meteo.meteoapplication

![main](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20nmain.png)

* Package meteo.meteoapplication.controller

![controller](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20controller.png)

* Package meteo.meteoapplication.exceptions

![exc](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20nexception.png)

* Package meteo.meteoapplication.filter

![filter](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20filter.png)

* Package meteo.meteoapplication.model

![model](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20model.png)

* Package meteo.meteoapplication.service 

![service](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20service.png)

* Package meteo.meteoapplication.stats

![stats](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20stats.png)

* Package meteo.meteoapplication.util

![util](https://github.com/GioelePasquini/project.java/blob/main/IMG/package%20util.png)


## Diagrammi delle sequenze

Di seguito sono riportati i diagrammi delle sequenze:

* /temp/{names}

![tempnames](https://github.com/GioelePasquini/project.java/blob/main/IMG/rotta%20temp.png)

* /save/{name}/{num_iter}

![save](https://github.com/GioelePasquini/project.java/blob/main/IMG/rotta%20save.png)

* /stats

![stats](https://github.com/GioelePasquini/project.java/blob/main/IMG/rotta%20stats.png)

* /limit/{type_temp}/{type_rel}/{limit}

![limit](https://github.com/GioelePasquini/project.java/blob/main/IMG/rotta%20limit.png)

* /rangingfrom/{type_temp}/{limitinf}/{limitsup}

![rf](https://github.com/GioelePasquini/project.java/blob/main/IMG/rotta%20rangingfrom.png)

* /periodically

![periodic](https://github.com/GioelePasquini/project.java/blob/main/IMG/rotta%20periodically.png)
