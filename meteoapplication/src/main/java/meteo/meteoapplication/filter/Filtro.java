package meteo.meteoapplication.filter;

public class Filtro {
	
	public Filtro(String citta, String type_stat, String first_day, String last_day) {
		super();
		this.citta = citta;
		this.type_stat = type_stat;
		this.first_day = first_day;
		this.last_day = last_day;
	}

	private String citta, type_stat, first_day,last_day;
	
	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getType_stat() {
		return type_stat;
	}

	public void setType_stat(String type_stat) {
		this.type_stat = type_stat;
	}

	public String getFirst_day() {
		return first_day;
	}

	public void setFirst_day(String first_day) {
		this.first_day = first_day;
	}

	public String getLast_day() {
		return last_day;
	}

	public void setLast_day(String last_day) {
		this.last_day = last_day;
	}

    
}
