package Practica1;

import java.util.ArrayList;

public class ej1class {
	
	private static ArrayList<Integer> numeros = new ArrayList<>();
	
	public static ArrayList<Integer> iterarFor(int num1, int num2) {
		int i;
		
		if (num1 > num2) {
			for(i = num2; i <= num1; i++) {
				numeros.add(i);
			}

		}
		else if (num2 > num1) {
			for(i = num1; i <= num2; i++) {
				numeros.add(i);
			}
		}
		else {
			System.out.println("Los numeros son iguales");
		}
			
		return numeros;
	}
	
	public static ArrayList<Integer> iterarWhile(int num1, int num2) {
		
		if(num1 > num2) {
			while (num2 <= num1) {
				numeros.add(num2);
				num2 ++;
			}
		}
		else if(num2 > num1) {
			while (num1 <= num2) {
				numeros.add(num1);
				num1 ++;
			}
		}
		else {
			System.out.println("Los numeros son iguales");
		}
		
		return numeros;
	}
	
	public static void borrar() {
		int pos = numeros.size()-1;
		while (pos >= 0) {
			numeros.remove(pos);
			pos --;
		}
	}
	
	public static ArrayList<Integer> sinEstructuras(int num1, int num2) {
		if(num1 == num2) {
			numeros.add(num1);
		}
		
		else if (num1 > num2) {
			if(num2 <= num1) {
				numeros.add(num2);
				sinEstructuras(num1,(num2 + 1));
			}
		}
		else {
			if(num1 <= num2) {
				numeros.add(num1);
				sinEstructuras((num1 + 1),num2);
			}
		}
			
		return numeros;
	}
}
