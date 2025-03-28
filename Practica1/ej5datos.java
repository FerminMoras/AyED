package Practica1;

public class ej5datos {

	private int minimo = 1000;
	private int maximo = -1000;
	private int promedio = 0;
	
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public int getPromedio() {
		return promedio;
	}
	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	
	public String toString() {
		String aux;
		
		aux = "Maximo: " + getMaximo() + " Minimo: " + getMinimo() + " Promedio: "
				+ getPromedio();
		
		return aux;
	}
}