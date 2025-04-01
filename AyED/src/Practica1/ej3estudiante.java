package Practica1;

public class ej3estudiante extends ej3fatherclass {
	private String comision;
	private String direccion;
	
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String aux;
		
		aux = super.tusDatos() + " Comision " + getComision() + 
		" Direccion " + getDireccion();		
		
		return aux;
	}
	
}
