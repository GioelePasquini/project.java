package meteo.meteoapplication.filter;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che definisce il Filtro 
 *
 */

public class Filtro {
	
	/**
	 * nome della città
	 */
	private String citta;
	
	/**
	 * tipo di statistica
	 */
	private String type_stat;
	
	/**
	 * primo giorno da cui leggere nel dataset
	 */
	private String first_day;
	
	/**
	 * ultimo giorno fino a cui leggere nel dataset
	 */
	private String last_day;
	
	/**
	 * periodicità (giornaliero/settimanale/personalizzabile)
	 */
	private String range;
	
	/**
	 * intero che specifica la periodicità in termini di giorni (1 per gionaliero, 7 per settimanale, n per personalizzabile)
	 */
	private int num_gg;
	
	
	/**
	 * Costruttore 
	 * 
	 * @param citta 
	 * @param type_stat
	 * @param first_day
	 * @param last_day
	 * 
	 */
	
	public Filtro(String citta, String type_stat, String first_day, String last_day) {
		super();
		this.citta = citta;
		this.type_stat = type_stat;
		this.first_day = first_day;
		this.last_day = last_day;
	}
	
	/**
	 * Getter citta
	 * @return citta
	 */
	public String getCitta() {
		return citta;
	}
	
	/**
	 * Setter citta
	 * @param citta
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * Getter type_stat
	 * @return type_stat 
	 */
	public String getType_stat() {
		return type_stat;
	}
	
	/**
	 * Setter type_stat
	 * @param type_stat
	 */
	public void setType_stat(String type_stat) {
		this.type_stat = type_stat;
	}

	/**
	 * Getter first_day
	 * @return first_day
	 */
	public String getFirst_day() {
		return first_day;
	}

	/**
	 * Setter first_day
	 * @param first_day
	 */
	public void setFirst_day(String first_day) {
		this.first_day = first_day;
	}

	/**
	 * Getter last_day
	 * @return last_day
	 */
	public String getLast_day() {
		return last_day;
	}

	/**
	 * Setter last_day
	 * @param last_day
	 */
	public void setLast_day(String last_day) {
		this.last_day = last_day;
	}

	/**
	 * Getter range
	 * @return range
	 */
	public String getRange() {
		return range;
	}

	/**
	 * Setter range
	 * @param range
	 */
	public void setRange(String range) {
		this.range = range;
	}

	/**
	 * Getter num_gg
	 * @return num_gg
	 */
	public int getNum_gg() {
		return num_gg;
	}

	/**
	 * Setter num_gg
	 * @param num_gg
	 */
	public void setNum_gg(int num_gg) {
		this.num_gg = num_gg;
	}

    
}














