package meteo.meteoapplication.stats;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Interfaccia Statistica
 *
 */

public interface Statistiche {
	
	/**
	 * Metodo che prende in ingreso una Media_varianza e restituisce un Object con la statistica
	 * @param st Media_Varianza
	 * @return Object 
	 */
	public Object stampastats(Media_Varianza st);
	
}
