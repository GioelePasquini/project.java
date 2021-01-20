package meteo.meteoapplication.filter;

import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;

import meteo.meteoapplication.exceptions.DatasetException;
import meteo.meteoapplication.exceptions.TypeException;
import meteo.meteoapplication.service.HistoricalService;
import meteo.meteoapplication.stats.Media;
import meteo.meteoapplication.stats.Media_Varianza;
import meteo.meteoapplication.stats.Varianza;
import meteo.meteoapplication.util.Util;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che contiene i metodi utilizzati per i filtri
 *
 */

public class Filtraggio {
	
/**
 * Variabili utilizzate in più metodi del controller
 */
	
	Media_Varianza mv=new Media_Varianza();
	Object ogg=new Object();
	HistoricalService h=new HistoricalService();
	Util u=new Util();
	Vector <JSONObject> obj=new Vector <JSONObject>();
    String s=new String();
	Vector <String> v=new Vector <String>();
	 
	 
	/**
	 * Metodo che filtra in base al tipo di statistica e alla città
	 * 
	 * @param stat tipo di statistica (media, varianza o entrambe)
	 * @param citta
	 * @param obj Vector contenente tutte le info raccolte nello storico
	 * 
	 * @return Object contenente la statistica filtrata
	 * 
	 * @throws TypeException
	 * 
	 */
	public Object Filtered_by_stat (String stat, String citta, Vector<JSONObject> obj) throws TypeException {
		
		
		switch (stat) {
		
		case "All" : {
			mv=u.calcolastats(obj,citta);
			ogg=mv;
			break;	
		}
		case "Media": {
			Media m=new Media();
			mv=u.calcolastats(obj,citta);
			ogg=m.stampastats(mv);
			break;
		}
		case "Varianza": {
			Varianza v=new Varianza();
			mv=u.calcolastats(obj,citta);
			ogg=v.stampastats(mv);
			 break;
		}
		default: throw new TypeException ("Request not valid: type of statistic not available.");
		}
		
		return ogg;
	}
	
	/**
	 * Metodo che filtra in base al tipo di relazione (maggiore o minore)
	 * 
	 * @param splitted vettore contenente le città inserite dall'utente
	 * @param param contiene i filtri
	 * @param type_rel (maggiore o minore)
	 * @param limite (limite numerico)
	 * @param type_temp tipo di temperatura da visualizzare 
	 * 
	 * @return Vector contenente le informazioni filtrate 
	 * 
	 * @throws TypeException
	 * @throws DatasetException
	 * 
	 */
	
	public Vector<String> Filtered_by_rel (String [] splitted, Filtro param, String type_rel, double limite,String type_temp) throws TypeException, DatasetException {
		
		
		if (type_temp.compareTo("temp_min")!=0 &type_temp.compareTo("temp_max")!=0 & type_temp.compareTo("feels_like")!=0 & type_temp.compareTo("temp")!=0)
			throw new TypeException ("Request not valid: type of temperature not found.");
		
		
		 for (int i=0; i<splitted.length; i++) {
	            obj=(h.ReadFrom(splitted[i], param.getFirst_day(), param.getLast_day()));
	            switch(type_rel) {
	            case "maggiore" :for(int j=0;j< obj.size(); j++) {
	                try {
	                    if(obj.get(j).getDouble(type_temp)>limite) {
	                        s=obj.get(j).getString("name")+", "+ obj.get(j).getString("day");
	                        v.add(s);
	                    }
	                    } catch (JSONException e) {
	                    e.printStackTrace();
	                    }
	                }break;
	            case "minore" :for(int j=0;j< obj.size(); j++) {
	                try {
	                    if(obj.get(j).getDouble(type_temp)<limite) {
	                        s=obj.get(j).getString("name")+", "+ obj.get(j).getString("day");
	                        v.add(s);
	                    }
	                    } catch (JSONException e) {
	                    e.printStackTrace();
	                    }
	              }break;
	            default  : throw new TypeException ("Request not valid: operator non valid.");
	        }
	    }
	        return v;
	}
	
	/**
	 * Metodo che filtra in base ai limiti superiore e inferiore passati dall'utente
	 * 
	 * @param splitted array che contiene le città
	 * @param limiteinf 
	 * @param limitesup
	 * @param param contiene i filtri
	 * @param type_temp temperatura da visualizzare
	 * 
	 * @return Vector di stringhe contenenti i giorni e le città filtrate
	 * 
	 * @throws DatasetExceptionù
	 * 
	 */
	
	public Vector<String> Filtred_by_limits (String[]splitted, double limiteinf, double limitesup, Filtro param, String type_temp) throws DatasetException {
		
		
		for (int i=0; i<splitted.length; i++) {
			obj=(h.ReadFrom(splitted[i], param.getFirst_day(), param.getLast_day()));
			
			for(int j=0;j< obj.size(); j++) {
					try {
						if(obj.get(j).getDouble(type_temp)>limiteinf && obj.get(j).getDouble(type_temp)<limitesup) {
							s=obj.get(j).getString("name")+", "+ obj.get(j).getString("day");
							v.add(s);
						}
						} catch (JSONException e) {
						e.printStackTrace();
					    }
		
			}
		}
		
		return v;
	}
	
	/**
	 * Metodo che riempie un Vector con Object contenenti le statistiche filtrate (in base alla città e al tipo di statistica)
	 * 
	 * @param dati Vector contenente le info dallo storico
	 * @param n giorni periodicità
	 * @param param contiene i filtri
	 * @param citta 
	 * 
	 * @return Vector di object contenente le statistiche filtrate
	 * 
	 * @throws TypeException
	 * 
	 */
	
	 public Vector<Object> fill_vector (Vector<JSONObject> dati,int n, Filtro param, String citta) throws TypeException {
		 
		   Vector<Object> risultato=new Vector<Object>();
		   int k=n;
		   int n_iter=dati.size()/n;
		   int counter=1;
		   for (int i=0; i<dati.size(); i+=n) {
			   for (int j=i; j<k && k<=dati.size(); j++) {
				   obj.add(dati.get(j));
			   }
			   k+=n;
			   ogg=Filtered_by_stat(param.getType_stat(),citta, obj);
			   if (counter<=n_iter) risultato.add(ogg);
			   obj.clear();
			   counter++;
		   }
		   return risultato;
	   }
	 
	 /**
	  * Metodo che utilizza fill_vector assegnando la periodicità in funzione della scelta dell'utente
	  * 
	  * @param citta
	  * @param param contiene i filtri
	  * @param ingresso Vector filtrato da fill_vector
	  * 
	  * @return Vector di Object contenente le informazioni filtrate in base alla periodicità
	  * 
	  * @throws TypeException
	  * @throws DatasetException
	  * 
	  */
	
	public Vector<Object> Filtred_by_range (String citta,Filtro param, Vector <JSONObject> ingresso ) throws TypeException, DatasetException {
		Vector<Object> res=new Vector<Object>();
		int n;
		
		switch (param.getRange()) {
		case "Daily" : {
			n=1;
			res=fill_vector(ingresso, n, param, citta);break;
			}		
		case "Weekly": {
			n=7;
			res=fill_vector(ingresso, n, param, citta);break;
		}
			
		case "Customizable" : {
			n=param.getNum_gg();
			res=fill_vector(ingresso, n, param, citta);break;
		}
			
		default : throw new DatasetException ("Request not valid.");
		}
		return res;
	}

}
