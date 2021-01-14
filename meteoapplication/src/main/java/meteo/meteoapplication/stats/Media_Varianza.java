package meteo.meteoapplication.stats;


public class Media_Varianza  {
	
	double vartemp,mediatemp,mediatemp_max,mediatemp_min,mediafeels_like;
	String nome;
	
	public Media_Varianza(String nome, double mediatemp, double mediatemp_max, double mediatemp_min,
			double mediafeels_like, double vartemp) {
		this.nome=nome;
		this.mediafeels_like=mediafeels_like;
		this.mediatemp=mediatemp;
		this.mediatemp_max=mediatemp_max;
		this.mediatemp_min=mediatemp_min;
		this.vartemp=vartemp;
	}


	public Media_Varianza () {
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
	
	public double getVartemp() {
		return vartemp;
	}
	
	public void setVartemp(double vartemp) {
		this.vartemp = vartemp;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}



}

