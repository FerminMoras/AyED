package Practica1;

import java.util.ArrayList;

public class ej5main {

	public static void main(String[] args) {
		ArrayList<Integer> v = new ArrayList<Integer>();
		
		v.add(100);
		v.add(2);
		v.add(54);
		v.add(23);
		v.add(5);
		v.add(77);
		
		ej5datos val = new ej5datos(); 
		ej5clas ej = new ej5clas();
		
		ej.setearValores(v,val);
		System.out.println("Maximo: " + val.getMaximo());
		System.out.println("Minimo: " + val.getMinimo());
		System.out.println("Promedio: " + val.getPromedio());
		
		System.out.println(ej.retornarValores(v).toString());
		
	}

}
