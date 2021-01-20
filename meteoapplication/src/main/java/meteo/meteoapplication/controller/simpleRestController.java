package meteo.meteoapplication.controller;


import meteo.meteoapplication.exceptions.CityException;
import meteo.meteoapplication.exceptions.DatasetException;
import meteo.meteoapplication.exceptions.TypeException;
import meteo.meteoapplication.filter.Filtraggio;
import meteo.meteoapplication.filter.Filtro;
import meteo.meteoapplication.model.*;
import meteo.meteoapplication.service.*;
import meteo.meteoapplication.util.Util;

import java.util.Vector;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che gestisce le richieste GET e POST dell'utente
 *
 */

@RestController
public class simpleRestController {
   
/**
 * Variabili utilizzate in più metodi del controller
 */
    Vector<JSONObject> obj=new Vector<JSONObject>();
    Util u=new Util();
    Temperatura t;
    Vector<Temperatura> vtemp=new Vector<Temperatura>();
    CurrentService s=new CurrentService();
    Temperatura [] a;
    Object o=new Object();
    Filtraggio f = new Filtraggio();
	HistoricalService h=new HistoricalService();
	Vector<String> v=new Vector<String>();
    
	
	/**
	 * Metodo GET che restituisce le temperature massime, minime, reali e percepite di una o più città inserite dall'utente
	 * 
	 * @param names
	 * 
	 * @return array di temperature
	 * 
	 */
    @GetMapping ("/temp/{names}")
    public Vector<Temperatura> getinfo(@PathVariable String names) throws CityException {
    	String[] splitted=names.split(",");
    	vtemp.clear();
    	for (int i=0; i< splitted.length;i++) {
    		obj=s.ReadFrom(splitted[i],"0","0");
            t=s.datawriter(obj);
            vtemp.add(t);
    	}
    	return vtemp;
    } 
    
    /**
     * Metodo GET che salva ora per ora le informazioni relative alla temperatura di una città
     * 
     * @param name
     * @param num_iter
     * 
     * @return Vector di temperature
     * 
     */
    
    @GetMapping("/save/{name}/{num_iter}")
    public Vector<Temperatura> oraperora(@PathVariable String name,
                                         @PathVariable int num_iter) { 
        vtemp=u.usetimer(name, num_iter);
        return vtemp;
    }
     
    /**
     * Metodo POST che filtra le statistiche in base a città, primo giorno, ultimo giorno e tipo di statistica (media, varianza o entrambe)
     * 
     * @param param contiene i filtri
     * 
     * @return Vector di Object che contiene le statistiche filtrate
     * 
     * @throws CityException
     * @throws DatasetException
     * @throws TypeException
     * 
     */
    
	@PostMapping ("/stats")
	public Vector<Object>  stats (@RequestBody Filtro param) throws CityException, DatasetException, TypeException  {
    	Vector<Object> vecret=new Vector<Object>();
    	vecret.clear();
		String[] splitted= param.getCitta().split(",");
		for (int i=0; i<splitted.length; i++) {
			obj=(h.ReadFrom(splitted[i], param.getFirst_day(), param.getLast_day()));
			o=f.Filtered_by_stat(param.getType_stat(),splitted[i],obj);
			vecret.add(o);
		}
		return vecret;
		
	}
	
	/**
	 * Metodo POST che restituisce le città e i giorni presenti nello storico con un tipo di temperatura (massima, minima, reale o percepita) 
	 * maggiore o minore di un valore scelto dall'utente.
	 * 
	 * @param param contiene i filtri
	 * @param type_temp tipo di temperatura da visualizzare 
	 * @param type_rel tipo di relazione (maggiore o minore)
	 * @param limit limite numerico 
	 * 
	 * @return Vector di stringhe contenenti i giorni e le città filtrate
	 * 
	 * @throws CityException
	 * @throws DatasetException
	 * @throws TypeException
	 * 
	 */
	
	@PostMapping ("limit/{type_temp}/{type_rel}/{limit}")
	public Vector<String> limit (@RequestBody Filtro param,
			                     @PathVariable String type_temp,
			                     @PathVariable String type_rel,
			                     @PathVariable double limit) throws CityException, DatasetException, TypeException {
		v.clear();
		String[] splitted= param.getCitta().split(",");
     	v=f.Filtered_by_rel(splitted,param,type_rel, limit,type_temp);
		return v;
	}
	
	/**
	 * Metodo POST che restituisce le città e i giorni presenti nello storico che hanno un tipo di temperatura compreso tra due valori passati 
	 * dall'utente
	 * 
	 * @param param contiene i filtri 
	 * @param type_temp tipo di temperatura da visualizzare 
	 * @param limitinf limite numerico inferiore 
	 * @param limitsup limite numerico superiore
	 * 
	 * @return Vector di stringhe contenenti i giorni e le città filtrate
	 * 
	 * @throws CityException
	 * @throws DatasetException
	 * 
	 */
	
	@PostMapping ("/rangingfrom/{type_temp}/{limitinf}/{limitsup}")
	public Vector<String> rangingfrom (@RequestBody Filtro param,
			                     @PathVariable String type_temp,
			                     @PathVariable double limitinf,
			                     @PathVariable double limitsup) throws CityException, DatasetException {
		v.clear();
		String[] splitted= param.getCitta().split(",");
		v=f.Filtred_by_limits(splitted, limitinf, limitsup, param, type_temp);
		return v;
	}
	
	/**
	 * Metodo POST che restituisce statistiche (media, varianza o entrambe) periodiche (giornaliere, settimanali o di range personalizzabile) 
	 * di una o più città presenti nello storico.
	 * 
	 * @param param coentiene i filtri
	 * 
	 * @return Vector di Object contenente le informazioni filtrate
	 * 
	 * @throws TypeException
	 * @throws DatasetException
	 * 
	 */

	@PostMapping ("/periodically")
	public Vector<Object> periodically  (@RequestBody Filtro param) throws TypeException, DatasetException {
		Vector <Object> v=new Vector <Object>();
		String[] splitted=param.getCitta().split(",");
    	for (int i=0; i< splitted.length;i++) {
		o=f.Filtred_by_range(splitted[i], param, h.ReadFrom(splitted[i], "01-12-2020", "15-12-2020"));
		v.add(o);
		}
    	return v;
    	
	}
		
}
