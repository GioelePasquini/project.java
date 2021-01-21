package meteo.meteoapplication.model;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che definisce Temperatura
 *
 */
public class Temperatura {
	
	/**
	 * nome della citta
	 */
	private String nome;
	
	/**
	 * temperatura minima
	 */
	private double temp_min;
	
	/**
	 * temperatura massima
	 */
	private double temp_max;
	
	/**
	 * temperatura percepita
	 */
	private double feel_like;
	
	/**
	 * temperatura reale
	 */
	private double temp;
	
	/**
	 * giorno
	 */
	private String giorno;
	
	/**
	 * Costruttore vuoto
	 */
	public Temperatura() {
	}
	
	/**
	 * Costruttore
	 * 
	 * @param nome  nome della città
	 * @param temp_min tempratura minima
	 * @param temp_max temperatura massima
	 * @param feel_like temperatura percepita
	 * @param temp temperatura reale
	 * @param giorno stringa contenente il giorno
	 * 
	 */
	public Temperatura(String nome, double temp_min, double temp_max, double feel_like, double temp, String giorno) {
		super();
		this.nome = nome;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.feel_like = feel_like;
		this.temp = temp;
		this.giorno = giorno;
	}
	
	/**
	 * Getter temp_min
	 * @return temp_min
	 */
	public double getTemp_min() {
		return temp_min;
	}	

	/**
	 * Setter temp_min
	 * @param temp_min temperatura minima
	 */
	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}
	
	/**
	 * Getter temp_max
	 * @return temp_max
	 */
	public double getTemp_max() {
		return temp_max;
	}
	
	/**
	 * Setter temp_max
	 * @param temp_max temperatura massima
	 */
	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}
	
	/**
	 * Getter feel_like
	 * @return feel_like
	 */
	public double getFeel_like() {
		return feel_like;
	}
	
	/**
	 * Setter feel_like
	 * @param feel_like temperatura percepita
	 */
	public void setFeel_like(double feel_like) {
		this.feel_like = feel_like;
	}
	
	/**
	 * Getter temp
	 * @return temp
	 */
	public double getTemp() {
		return temp;
	}
	
	/**
	 * Setter temp
	 * @param temp temperatura reale
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * Getter nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Setter nome
	 * @param nome citta
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Getter giorno
	 * @return giorno
	 */
	public String getGiorno() {
		return giorno;
	}

	/**
	 * Setter giorno
	 * @param giorno giorno corrente
	 */
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
		
}