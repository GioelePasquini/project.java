package meteo.meteoapplication.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

import meteo.meteoapplication.exceptions.CityException;

import meteo.meteoapplication.model.Temperatura;
import meteo.meteoapplication.service.CurrentService;
import meteo.meteoapplication.stats.Media_Varianza;

 

public class Util {
    CurrentService s= new CurrentService ();
    Vector<JSONObject> obj=new Vector<JSONObject>();
    private int counter=1;
    Vector<Temperatura> v= new Vector<Temperatura>();
    
    public  Vector<Temperatura> usetimer (String City, int num_iter) {
        
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            if (counter<=num_iter) {
            Temperatura t=new Temperatura();
            try {
				obj=s.ReadFrom(City,"0","0");
			} catch (CityException e) {
				e.printStackTrace();
			}
            t=s.datawriter(obj);
            v.add(t);
            counter++;
        }
            else timer.cancel();
            }
        },0, 1000);
    
        return v;
     }
    
   public String today (JSONObject obj) throws JSONException {
	   long unix_seconds = obj.getLong("dt");
       Date date = new Date(unix_seconds*1000L); 
       SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
       jdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
       String java_date = jdf.format(date);
       return java_date;
   }
   
   public Media_Varianza calcolastats(Vector<JSONObject> v, String nome) {
	   double mediatemp,mediatemp_min,mediatemp_max,mediafeels_like,vartemp;
	   double sommatemp=0;
       double sommamin=0;
       double sommamax=0;
       double sommafeels=0;
       for(int i=0; i<v.size(); i++) {
       	try {
       	sommatemp+=v.get(i).getDouble("temp");
		    sommamin+=v.get(i).getDouble("temp_min");
			sommamax+=v.get(i).getDouble("temp_max");
			sommafeels+=v.get(i).getDouble("feels_like");
			} catch (JSONException e) {
				e.printStackTrace();
			}
       }
       mediatemp=sommatemp/v.size();
       mediatemp_max=sommamax/v.size();
       mediatemp_min=sommamin/v.size();
       mediafeels_like=sommafeels/v.size();
       vartemp= Math.abs(mediafeels_like-mediatemp);
       Media_Varianza mv= new Media_Varianza (nome,mediatemp_min,mediatemp_max,mediatemp,mediafeels_like,vartemp);
       return mv;
   }

public CurrentService getS() {
	return s;
}

public void setS(CurrentService s) {
	this.s = s;
}

public Vector<JSONObject> getObj() {
	return obj;
}

public void setObj(Vector<JSONObject> obj) {
	this.obj = obj;
}

public int getCounter() {
	return counter;
}

public void setCounter(int counter) {
	this.counter = counter;
}

public Vector<Temperatura> getV() {
	return v;
}

public void setV(Vector<Temperatura> v) {
	this.v = v;
}
    
}
