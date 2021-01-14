package meteo.meteoapplication.stats;


 

public class Varianza implements Statistiche {

 

    protected double vartemp;
    protected String nome;
    
    
    public Varianza(String nome, double vartemp) {
        this.nome=nome;
        this.vartemp=vartemp;
    }
    
    public Varianza() {
        
    }

    @Override
    public Object stampastats(Media_Varianza st) {
        Varianza v=new Varianza(st.getNome(),st.getVartemp());
        return v;
    }
    
    
    public String getNome() {
		return nome;
	}
    
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    public double getVartemp() {
        return vartemp;
    }
    
    public void setVartemp(double vartemp) {
        this.vartemp = vartemp;
    }

 

    
}
