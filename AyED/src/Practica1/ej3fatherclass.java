package Practica1;

public class ej3fatherclass {
	private String nombre;
	private String apellido;
	private String email;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String tusDatos() {
		
		String aux;
		
		aux = "Nombre " + getNombre() + " Apellido " + getApellido()  
		+ " Email " + getEmail();
		
		return aux;
	}
}
