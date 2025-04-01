package Practica1;

import java.util.ArrayList;

public class ej5clas{
	
	public ej5datos retornarValores(ArrayList<Integer> vector) {
		ej5datos aux = new ej5datos();
		
		int i;
		
		for(i = 0; i < vector.size(); i++) {
			
			//MAXIMO
			if (vector.get(i) > aux.getMaximo()) {
				aux.setMaximo(vector.get(i));
			}
			
			//MINIMO
			if (vector.get(i) < aux.getMinimo()) {
				aux.setMinimo(vector.get(i));
			}
			
			//PROMEDIO
			aux.setPromedio(aux.getPromedio() + vector.get(i));
		}
		aux.setPromedio(aux.getPromedio() / vector.size());
		
		return aux;
	}
	
	public void setearValores(ArrayList<Integer> vector, ej5datos valores) {
		int i;
		
		for(i = 0; i < vector.size(); i++) {
			
			//MAXIMO
			if (vector.get(i) > valores.getMaximo()) {
				valores.setMaximo(vector.get(i));
			}
			
			//MINIMO
			if (vector.get(i) < valores.getMinimo()) {
				valores.setMinimo(vector.get(i));
			}
			
			//PROMEDIO
			valores.setPromedio(valores.getPromedio() + vector.get(i));
		}
		
		valores.setPromedio(valores.getPromedio() / vector.size());
	}
}
