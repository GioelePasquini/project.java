package meteo.meteoapplication.service;

 

import meteo.meteoapplication.exceptions.CityException;
import meteo.meteoapplication.exceptions.DatasetException;
import meteo.meteoapplication.model.*;
import meteo.meteoapplication.util.Util;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;
 

public abstract class Service {
	
    public abstract Vector<JSONObject> ReadFrom(String citta, String firstday, String lastday) throws CityException,DatasetException;
    
    public Temperatura datawriter (Vector<JSONObject> ogg)  {
    	Util u=new Util();
        double real=0;
        double max=0;
        double min=0;
        double feels=0;
        String day=new String();
        String citta=new String();
        
        JSONObject obj=new JSONObject();
        obj= ogg.firstElement();
        try {
        citta=obj.getString("name");
        JSONObject head= obj.getJSONObject("main"); 
        real= head.getDouble("temp");              
        max= head.getDouble("temp_max");
        min= head.getDouble("temp_min");
        feels= head.getDouble("feels_like");
        day=u.today(obj);
        
        } 
        catch (JSONException e) {
            e.printStackTrace();
        }  
        
        Temperatura dati_utili= new Temperatura(citta,real,feels,min,max,day);
        return dati_utili;
    }
        

 

}