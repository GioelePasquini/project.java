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

public class Filtraggio {
	
	
	Media_Varianza mv=new Media_Varianza();
	Object ogg=new Object();
	HistoricalService h=new HistoricalService();
	Util u=new Util();
	Vector <JSONObject> obj=new Vector <JSONObject>();
    String s=new String();
	Vector <String> v=new Vector <String>();
	 
	 
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

}
