package Practica1;

import java.util.ArrayList;

public class ej3main {
	
	public static void main(String[] args) {
		ArrayList<ej3profesor> vectorP = new ArrayList<>();
		ArrayList<ej3estudiante> vectorE = new ArrayList<>();
		
		// VECTOR PROFESORES
		
		ej3profesor p1 = new ej3profesor();
		
		p1.setNombre("pablo");
		p1.setApellido("rodriguez");
		p1.setEmail("pablorodriguez@gmail.com");
		p1.setCatedra("cadp");
		p1.setFacultad("unlp");
		
		vectorP.add(p1);
		
		ej3profesor p2 = new ej3profesor();
		
		p2.setNombre("fermin");
		p2.setApellido("palermo");
		p2.setEmail("ferminpalermo@gmail.com");
		p2.setCatedra("taller");
		p2.setFacultad("unlp");
		
		vectorP.add(p2);
		
		ej3profesor p3 = new ej3profesor();
		
		p3.setNombre("roman");
		p3.setApellido("sosa");
		p3.setEmail("romansosa@gmail.com");
		p3.setCatedra("arqui");
		p3.setFacultad("unlp");
		
		vectorP.add(p3);
		
		System.out.println("Datos de los profesores");
		System.out.println();
		
		for(int i = 0; i < vectorP.size(); i++) {
			System.out.println(vectorP.get(i).tusDatos());
		}
		
		//VECTOR ESTUDIANTES
		
		ej3estudiante e1 = new ej3estudiante();
		
		e1.setNombre("tomas");
		e1.setApellido("rodriguez");
		e1.setEmail("tomasrodriguez@gmail.com");
		e1.setComision("T1");
		e1.setDireccion("unlp");
		
		vectorE.add(e1);
		
		ej3estudiante e2 = new ej3estudiante();
		
		e2.setNombre("ramon");
		e2.setApellido("abila");
		e2.setEmail("wanchopeabila@gmail.com");
		e2.setComision("T2");
		e2.setDireccion("unlp");
		
		vectorE.add(e2);
		
		System.out.println();
		System.out.println("Datos de los estudiantes");
		System.out.println();
		
		for(int i = 0; i < vectorE.size(); i++) {
			System.out.println(vectorE.get(i).tusDatos());
		}
	}
}
