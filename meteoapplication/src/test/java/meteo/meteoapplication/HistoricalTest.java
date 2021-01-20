package meteo.meteoapplication;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import meteo.meteoapplication.service.HistoricalService;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe usata per testare il corretto funzionamento della funzione ReadFrom
 * Conoscendo i valori del dataset si testa la corrispondenza
 *
 */
public class HistoricalTest {
	private String citta;
	HistoricalService h=new HistoricalService();
	Vector <JSONObject> v=new Vector<JSONObject>();
	
	@BeforeEach
	void setUp() throws Exception {
		citta = "Rome"; //esempio di città presente nel dataset
		v=h.ReadFrom(citta, "01-12-2020", "15-12-2020"); 
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test() throws JSONException {
		
		assertEquals(v.get(8).get("temp_max"), 282.31 );
	}

}
