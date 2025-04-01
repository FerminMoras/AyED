package Practica1;

import java.util.ArrayList;
import java.util.Scanner;

public class ej2class {
	
	private static ArrayList<Integer> vector = new ArrayList<>();
	
	public static ArrayList<Integer> vector(int x) {
		int i;
		for(i=1; i <= x; i++) {
			vector.add(x*i);
		}
		
		return vector;
	}
	
	public static int leerdatos() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresar un numero");
		int num = sc.nextInt();
		
		sc.close();
		
		return num;
	}
	
}
