package meteo.meteoapplication.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;

import meteo.meteoapplication.exceptions.CityException;


/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 *
 *Classe che estende la classe astratta Service
 *Legge le informazioni attuali sulla temperatura collegandosi all'API di openweather
 *
 */
public class CurrentService extends Service {

	/**
	 * Override del metodo ReadFrom
	 * Carica un Vector con le informazioni relative alla temperatura lette dall'API
	 */
    @Override
    public Vector<JSONObject> ReadFrom(String citta, String firstday, String lastday) throws CityException {
        {
            String APIkey="b3bc4992590eca1178322323b239d122";
            String link="http://api.openweathermap.org/data/2.5/weather?q="+citta+"&APPID="+APIkey;
            Vector<JSONObject> vobj=new Vector<JSONObject>();
            JSONObject obj=new JSONObject();
            String zero =new String ();
            try {
                
                HttpURLConnection  URLconn = (HttpURLConnection) new URL (link).openConnection();
                URLconn.connect();
                String info= new String ();
                BufferedReader in =new BufferedReader(new InputStreamReader(URLconn.getInputStream()));
                 while( (info=in.readLine())!=null ) {
                     zero+=info;
                 }
                 obj= new JSONObject(zero);
            }
            catch(IOException | JSONException e ) {
              e.printStackTrace();
            }
           
            if (zero.isBlank())
           	 throw new CityException ("Request not valid: the city doesn't exist.");
            vobj.add(obj);
            return vobj; 
        }
        
        
    }

 

}
