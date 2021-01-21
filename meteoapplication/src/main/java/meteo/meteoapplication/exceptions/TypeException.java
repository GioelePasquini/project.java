package meteo.meteoapplication.exceptions;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che gestisce le eccezioni riguardanti il tipo (di statistiche o di temperatura)
 *
 */

public class TypeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore
	 */
	public TypeException () {
		super();
	}
	
	/**
	 * 
	 * @param msg messaggio d'errore
	 */
	public TypeException (String msg) {
		super(msg);
	}

}
