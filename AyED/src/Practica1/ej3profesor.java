package Practica1;

public class ej3profesor extends ej3fatherclass{
	private String catedra;
	private String facultad;
	
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String aux;
		
		aux = super.tusDatos() + " Catedra " + getCatedra() + 
		" Facultad " + getFacultad();	
		
		return aux;
	}
	
	
}
