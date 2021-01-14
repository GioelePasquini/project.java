package meteo.meteoapplication.stats;

public class Media implements Statistiche {
    
	   double mediatemp,mediatemp_max,mediatemp_min,mediafeels_like;
	    String nome;
	    
    public Media(String nome,double mediatemp,double mediatemp_max,double mediatemp_min,double mediafeels_like) {
        this.nome=nome;
        this.mediafeels_like=mediafeels_like;
        this.mediatemp=mediatemp;
        this.mediatemp_max=mediatemp_max;
        this.mediatemp_min=mediatemp_min;
    }

 
    public Media() {
        
    }
    
    @Override
    public Object stampastats(Media_Varianza st) {
        Media m=new Media(st.getNome(),st.getMediatemp(),st.getMediatemp_max(),st.getMediatemp_min(),st.getMediafeels_like());
        return m;
    }

    
    public double getMediatemp() {
        return mediatemp;
    }
    
    public void setMediatemp(double mediatemp) {
        this.mediatemp = mediatemp;
    }
    
    public double getMediatemp_max() {
        return mediatemp_max;
    }
    
    public void setMediatemp_max(double mediatemp_max) {
        this.mediatemp_max = mediatemp_max;
    }
    
    public double getMediatemp_min() {
        return mediatemp_min;
    }
    
    public void setMediatemp_min(double mediatemp_min) {
        this.mediatemp_min = mediatemp_min;
    }
    
    public double getMediafeels_like() {
        return mediafeels_like;
    }
    
    public void setMediafeels_like(double mediafeels_like) {
        this.mediafeels_like = mediafeels_like;
    }
    
    public String getNome() {
		return nome;
	}
    
    public void setNome(String nome) {
		this.nome = nome;
	}

}
