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

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * classe che contiene metodi utili al programma
 *
 */

public class Util {
	
	/**
	 * elementi condivisi dai metodi della classe
	 */
    CurrentService s= new CurrentService ();
    Vector<JSONObject> obj=new Vector<JSONObject>();
    private int counter=1;
   //FORSE CANC Vector<Temperatura> v= new Vector<Temperatura>();
    
    /**
     * metodo che prende in ingresso il nome di una città e il numero di iterazioni e salva le informazioni lette dall'api ogni ora per n volte
     * e salva le informazioni
     * 
     * @param City
     * @param num_iter
     * 
     * @return Vector<Temperatura> contenente tutte le temperature lette 
     */
    public  Vector<Temperatura> usetimer (String City, int num_iter) {
    Vector<Temperatura> v= new Vector<Temperatura>();
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
        },0, 3600000);
    
        return v;
     }
    
   /**
    * metodo che prende in ingresso il JSONObject letto dall'api contenente il giorno corrente in formato unix, lo converte in formato
    * anno-mese-giorno e restituisce una stringa
    * 
    * @param obj
    * @return String 
    * 
    * @throws JSONException
    * 
    */
   public String today (JSONObject obj) throws JSONException {
	   long unix_seconds = obj.getLong("dt");
       Date date = new Date(unix_seconds*1000L); 
       SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
       jdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
       String java_date = jdf.format(date);
       return java_date;
   }
   
   /**
    * metodo che prende in ingresso un Vector e una stringa contenente il nome della città e restituisce un oggetto Media_Varianza
    * contenente le statistiche 
    * 
    * @param v
    * @param nome
    * 
    * @return Media_Varianza
    */
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
       Media_Varianza mv= new Media_Varianza (nome,mediatemp,mediatemp_max,mediatemp_min,mediafeels_like,vartemp);
       return mv;
   }

}
