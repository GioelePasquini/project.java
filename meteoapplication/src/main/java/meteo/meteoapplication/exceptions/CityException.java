package meteo.meteoapplication.exceptions;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che gestisce le eccezioni riguardanti città
 *
 */
public class CityException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * costruttore
	 */
	public CityException () {
			super();
		}
		
		/**
		 * 
		 * @param msg messaggio d'errore
		 */
		public CityException (String msg) {
			super(msg);
		}

}
