package meteo.meteoapplication.model;

public class Temperatura {
	
	private String nome;
	private double temp_min;
	private double temp_max;
	private double feel_like;
	private double temp;
	private String giorno;
	
	public Temperatura() {
	}
	
	public Temperatura(String nome, double temp_min, double temp_max, double feel_like, double temp, String giorno) {
		super();
		this.nome = nome;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.feel_like = feel_like;
		this.temp = temp;
		this.giorno = giorno;
	}
	public double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	public double getFeel_like() {
		return feel_like;
	}

	public void setFeel_like(double feel_like) {
		this.feel_like = feel_like;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
		
}