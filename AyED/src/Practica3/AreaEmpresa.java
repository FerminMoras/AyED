package Practica3;

public class AreaEmpresa {
	private String id;
	private int tiempo;
	
	public AreaEmpresa (String iden, int time) {
		this.id = iden;
		this.tiempo = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
