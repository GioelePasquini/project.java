package meteo.meteoapplication.exceptions;

public class CityException extends Exception {
	
	private static final long serialVersionUID = 1L;

		public CityException () {
			super();
		}
		
		public CityException (String msg) {
			super(msg);
		}

}
