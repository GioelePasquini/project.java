package meteo.meteoapplication.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;

import meteo.meteoapplication.exceptions.DatasetException;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che estende la classe astratta Service
 * Legge le informazioni sulla temperatura contenute nel dataset
 *
 */
public class HistoricalService extends Service {

	/**
	 * Override del metodo ReadFrom
	 * Carica un Vector con le informazioni relative alla temperatura lette dal dataset
	 */
	@Override
	public Vector<JSONObject> ReadFrom(String citta, String firstday, String lastday) throws DatasetException {
		
		String[] splitted1=firstday.split("-");
		String[] splitted2=lastday.split("-");
		if(splitted1[1].compareTo("12")!=0 | splitted2[1].compareTo("12")!=0 )
			throw new DatasetException ("Request not valid: period not valid.");
				
		if(splitted1[2].compareTo(splitted2[2])>0 | splitted2[2].compareTo("2020")!=0)
			throw new DatasetException ("Request not valid: period not valid.");
		
		if(splitted2[0].compareTo("15")>0 | splitted1[0].compareTo("01")<0 | splitted1[0].compareTo(splitted2[0])>0 ) 
			throw new DatasetException ("Request not valid: period not valid.");
		
		if (citta.compareTo("Rome")!=0 && citta.compareTo("London")!=0)
			throw new DatasetException ("Request not valid: city not found in the dataset.");
		
		
		
		JSONObject j=new JSONObject();
		Vector <JSONObject> v1=new Vector<JSONObject> ();
		Vector <JSONObject> v2=new Vector <JSONObject>();
		    String content = null;
		    File file = new File("dataset.txt");
		    FileReader reader = null;
		    
		    try {
		        reader = new FileReader(file);
		        char[] chars = new char[(int) file.length()];
		        reader.read(chars);
		        content = new String(chars);
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if(reader != null){
		            try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
		    }
		    String text=content; 
		    String [] splitted= text.split(";");
		    for (int i=0; i<splitted.length;i++) {
		    	try {
					j= new JSONObject (splitted[i]);
				} catch (JSONException e) {
					e.printStackTrace();
				}
		    	v1.add(j);
		    }
		for (int i=0; i<v1.size();i++) {
			try {
				if(firstday.compareTo(v1.get(i).getString("day"))<=0 && lastday.compareTo(v1.get(i).getString("day"))>=0 && v1.get(i).getString("name").compareTo(citta)==0) {
				v2.add(v1.get(i));	
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			
		}
		return v2;
     }

}
