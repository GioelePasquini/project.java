package meteo.meteoapplication.stats;

/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * classe che estende l'interfaccia Statistiche 
 *
 */
public class Media implements Statistiche {
    
	/**
	 * 
	 */
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
	 private String nome;
	    
	 /**
	  * Costruttore 
	  * @param nome citta
	  * @param mediatemp media temperature reali
	  * @param mediatemp_max media temperature massime
	  * @param mediatemp_min media temperature minime
	  * @param mediafeels_like media temperature percepite
	  */
    public Media(String nome,double mediatemp,double mediatemp_max,double mediatemp_min,double mediafeels_like) {
        this.nome=nome;
        this.mediafeels_like=mediafeels_like;
        this.mediatemp=mediatemp;
        this.mediatemp_max=mediatemp_max;
        this.mediatemp_min=mediatemp_min;
    }
    
    /**
     * Costruttore vuoto
     */
    public Media() {
        
    }
    
    /**
     * Override metodo stampastats dell'interfaccia
     * Prende in ingresso una Media_Varianza e restituisce un oggetto Media 
     */
    @Override
    public Object stampastats(Media_Varianza st) {
        Media m=new Media(st.getNome(),st.getMediatemp(),st.getMediatemp_max(),st.getMediatemp_min(),st.getMediafeels_like());
        return m;
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
	 * @param mediatemp media temperature reali
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
	 * @param mediatemp_max media temperature massime
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
	 * @param mediatemp_min media temperature mminime
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
	 * @param mediafeels_like media temperature percepite
	 */
	public void setMediafeels_like(double mediafeels_like) {
		this.mediafeels_like = mediafeels_like;
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



}
