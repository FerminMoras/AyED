package Practica1;

import java.util.ArrayList;
import java.util.*;

public class ej7testArrayList {
 
	public static void imprimir (ArrayList<Integer> v) {
		Iterator<Integer> it = v.iterator();
		
		while(it.hasNext()) {
			System.out.println("Numero " + it.next());
		}
	}
	
	public static void alternativa(ArrayList<Integer> v) {
		//Se puede recorrer utilizando una estructura for y accediendo a los datos del arraylist mediante get(i).
		
		for(int i = 0; i < v.size(); i++) {
			System.out.println("Numero con Alternativa: " + v.get(i));
		}
	}
	
	public static void lista(ArrayList<ej3estudiante> vector1,ArrayList<ej3estudiante> vector2) {
		Iterator<ej3estudiante> it = vector1.iterator();
		
		while(it.hasNext()) {
			vector2.add(it.next());
		}
	}	
		
	public ej7testArrayList(ArrayList<Integer> v) {
		ArrayList<Integer> listaEst3 = new ArrayList<Integer>(); //NUEVA LISTA DONDE SE COPIAN LOS DATOS
		listaEst3.addAll(v);
	}
	
	public static void agregarEst(ArrayList<ej3estudiante> v, ej3estudiante e) {
		//la operacion contains(elemento) devuelve true si esta en la lista o false caso contrario.
		
		if (v.contains(e)) {
			System.out.println("El estudiante esta en la lista");
		}
		else {
			v.add(e);
		}
	}
	
	public static String imprimirLista(ArrayList<ej3estudiante> v) {
		String aux = "";
		
		for(int i = 0; i < v.size(); i++) {
			aux += v.get(i).tusDatos();
		}
		
		return aux;
	}
	
	public static boolean esCapicua(ArrayList<Integer> v) {
		boolean ok = false;
		
		
		return ok;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> v = new ArrayList<Integer>();
		ArrayList<ej3estudiante> listaEst1 = new ArrayList<ej3estudiante>();
		ArrayList<ej3estudiante> listaEst2 = new ArrayList<ej3estudiante>();
		// ArrayList<ej3estudiante> est2 = est1; --> Una forma de copiar una lista es asignandola a una lista previamente ya creada. 
		
		v.add(5);
		v.add(15);
		v.add(3);
		v.add(21);
		v.add(11);
		
		ej3estudiante e1 = new ej3estudiante();
		
		e1.setNombre("Fermin");
		e1.setApellido("Moras");
		e1.setComision("T1");
		e1.setDireccion("La Rioja 668");
		e1.setEmail("ferminmoras@gmail.com");
		
		listaEst1.add(e1);
		
		ej3estudiante e2 = new ej3estudiante();
		
		e2.setNombre("Tomas");
		e2.setApellido("Perez");
		e2.setComision("T2");
		e2.setDireccion("avenida 5");
		e2.setEmail("tomasperez@gmail.com");
		
		listaEst1.add(e2);
		
		ej3estudiante e3 = new ej3estudiante();
		
		e3.setNombre("Ramon");
		e3.setApellido("Abila");
		e3.setComision("T3");
		e3.setDireccion("avenida 15");
		e3.setEmail("wanchopeabila@gmail.com");
		
		listaEst1.add(e3);
		
		ej3estudiante e4 = new ej3estudiante();
		
		e4.setNombre("Ricardo");
		e4.setApellido("Centurion");
		e4.setComision("T4");
		e4.setDireccion("falopa");
		e4.setEmail("rikicenturion22@gmail.com");
		
		//otra forma de copiar una estructura de datos es creando una nueva en su constructor y usar la operacion addAll.
		ArrayList<Integer> vectorEnteros = new ArrayList<Integer>(v);
		System.out.println("VECTOR COPIADO");
		imprimir(vectorEnteros);
		
		//otra forma es usando la operacion clone, pero no se recomienda ya que se tiene que castear.
		
		//la otra forma es creando otra lista, pasar las dos por parametro y leer los valores e ir agg a la que esta vacia.
		lista(listaEst1,listaEst2);
		agregarEst(listaEst1,e4);
		System.out.println(imprimirLista(listaEst1));
		
		//INCISO A Y C
		imprimir(v);
		alternativa(v);
	
		}	
	
		//Inciso B: no encuentro diferencia alguna en este tipo de ejercicio entre el arraylist y linkedlist, ya que lo implemente de
		//la misma forma y los resultados son los mismos. La diferencia esta en cuanto lo que se requiere en el programa, si necesitas
		//un programa que haga muchos corrimientos y agregar o eliminar datos, es mas eficiente el uso de una linkedlist, pero si 
		//necesitas un programa donde tenes q acceder a los elementos y obtener la informacion solamente es mas eficiente el uso de 
		//arraylist, ya que el acceso a los elementos es indexado. En este inciso A solamente te pide que recorras completas ambas 
		//estructuras, por lo tanto no encuentro una diferencia.
	
		
	
		
	}


