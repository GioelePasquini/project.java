package meteo.meteoapplication.stats;
 
/**
 * 
 * @author Gioele Pasquini
 * @author Umberto Maraglino
 * 
 * classe che estende l'interfaccia Statistiche 
 * 
 */
public class Varianza implements Statistiche {

 
	/**
	 * varianza
	 */
    protected double vartemp;
    
    /**
     * nome città
     */
    protected String nome;
    
    /**
     * costruttore
     * 
     * @param nome
     * @param vartemp
     */
    public Varianza(String nome, double vartemp) {
        this.nome=nome;
        this.vartemp=vartemp;
    }
    
    /**
     * costruttore vuoto
     */
    public Varianza() {
        
    }

    /**
     * Override del metodo stampastats dell'interfaccia
     * Prende in ingresso una Media_Varianza e restituisce un oggetto Varianza
     */
    @Override
    public Object stampastats(Media_Varianza st) {
        Varianza v=new Varianza(st.getNome(),st.getVartemp());
        return v;
    }
    
    /**
     * Getter nome
     * @return
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

    
}
