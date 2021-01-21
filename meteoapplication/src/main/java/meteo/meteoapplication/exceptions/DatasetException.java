package meteo.meteoapplication.exceptions;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che gestisce le eccezioni riguardanti lo storico
 *
 */

public class DatasetException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore
	 */
	public DatasetException () {
		super();
	}
	
	/**
	 * 
	 * @param msg messaggio d'errore
	 */
	public DatasetException (String msg) {
		super(msg);
	}

}

