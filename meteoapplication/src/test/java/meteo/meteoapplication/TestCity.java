package meteo.meteoapplication;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import meteo.meteoapplication.exceptions.CityException;
import meteo.meteoapplication.service.CurrentService;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 *
 *Classe usata per testare l'eccezione CityException
 */
public class TestCity {
	private String citta;
	
	@BeforeEach
	void setUp() throws Exception {
		citta = "CittaNonEsistente"; //esempio di città non esistente
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test() throws CityException {
		CurrentService s=new CurrentService();
		CityException exception = assertThrows(CityException.class, () -> {
			 s.ReadFrom(citta, "0", "0");
		 });
		assertEquals("Request not valid: the city doesn't exist.",exception.getMessage());
	}

}
