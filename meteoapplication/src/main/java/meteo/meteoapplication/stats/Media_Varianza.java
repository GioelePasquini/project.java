package meteo.meteoapplication.stats;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * Classe che definisce un oggetto che contiene le medie e la varianza 
 *
 */
public class Media_Varianza  {
	
	/**
	 * varianza 
	 */
	private double vartemp;
	
	/**
	 * media temperature reali
	 */
	private double mediatemp;
	
	/**
	 * media temperature massime
	 */
	private double mediatemp_max;
	
	/**
	 * media temperature minime
	 */
	private double mediatemp_min;
	
	/**
	 * media temperature percepite
	 */
	private double mediafeels_like;
	
	/**
	 * nome città
	 */
	String nome;
	
	/**
	 * costruttore
	 * @param nome
	 * @param mediatemp
	 * @param mediatemp_max
	 * @param mediatemp_min
	 * @param mediafeels_like
	 * @param vartemp
	 */
	public Media_Varianza(String nome, double mediatemp, double mediatemp_max, double mediatemp_min,
			double mediafeels_like, double vartemp) {
		this.nome=nome;
		this.mediafeels_like=mediafeels_like;
		this.mediatemp=mediatemp;
		this.mediatemp_max=mediatemp_max;
		this.mediatemp_min=mediatemp_min;
		this.vartemp=vartemp;
	}


	/**
	 * costruttore vuoto
	 */
	public Media_Varianza () {
	}
	

	/**
	 * Getter mediatemp
	 * @return mediatemp
	 */
	public double getMediatemp() {
		return mediatemp;
	}
	
	/**
	 * Setter mediatemp
	 * @param mediatemp
	 */
	public void setMediatemp(double mediatemp) {
		this.mediatemp = mediatemp;
	}
	
	/**
	 * Getter media_tempmax
	 * @return media_tempmax
	 */
	public double getMediatemp_max() {
		return mediatemp_max;
	}
	
	/**
	 * Setter media_tempmax
	 * @param mediatemp_max
	 */
	public void setMediatemp_max(double mediatemp_max) {
		this.mediatemp_max = mediatemp_max;
	}
	
	/**
	 * Getter mediatemp_min
	 * @return mediatemp_min
	 */
	public double getMediatemp_min() {
		return mediatemp_min;
	}
	
	/**
	 * Setter mediatemp_min
	 * @param mediatemp_min
	 */
	public void setMediatemp_min(double mediatemp_min) {
		this.mediatemp_min = mediatemp_min;
	}
	
	/**
	 * Getter mediafeels_like
	 * @return mediafeels_like
	 */
	public double getMediafeels_like() {
		return mediafeels_like;
	}
	
	/**
	 * Setter mediafeels_like
	 * @param mediafeels_like
	 */
	public void setMediafeels_like(double mediafeels_like) {
		this.mediafeels_like = mediafeels_like;
	}
	
	/**
	 * Getter vartemp
	 * @return vartemp
	 */
	public double getVartemp() {
		return vartemp;
	}
	
	/**
	 * Setter vartemp
	 * @param vartemp
	 */
	public void setVartemp(double vartemp) {
		this.vartemp = vartemp;
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
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}



}

