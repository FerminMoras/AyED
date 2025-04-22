package Practica3;
import Practica1.Queue;
import java.util.*;

public class AnalizadorArbol {
	
	public static double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		if((arbol != null) && (arbol.isEmpty()))
			return 0.0;
		else
			return calcularPromedio(arbol);
	}
	
	private static double calcularPromedio(GeneralTree<AreaEmpresa> a) {
		double max = -1.0;
		double suma = 0;
		int cant = 0;
		
		GeneralTree<AreaEmpresa> aux;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue();
		cola.enqueue(a);
		cola.enqueue(null);
		
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				cant++;
				suma = suma + aux.getData().getTiempo();
				List<GeneralTree<AreaEmpresa>> hijos = aux.getChildren();
				for(GeneralTree<AreaEmpresa> hijo: hijos) {
					cola.enqueue(hijo);
				}
			}else if (!cola.isEmpty()){
				suma = suma / cant;
				max = Math.max(suma, max);
				cola.enqueue(null);
				suma = 0;
				cant = 0;
			}
		}
		return max;
	}
	
	public static void main (String args[]) {
		GeneralTree<AreaEmpresa> nodo14 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",14));
		
		GeneralTree<AreaEmpresa> nodo13 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",13));
		GeneralTree<AreaEmpresa> nodo25 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",25));
		GeneralTree<AreaEmpresa> nodo10 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",10));
		
		GeneralTree<AreaEmpresa> nodo4 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",4));
		GeneralTree<AreaEmpresa> nodo7 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",7));
		GeneralTree<AreaEmpresa> nodo5 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",5));
		GeneralTree<AreaEmpresa> nodo6 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",6));
		GeneralTree<AreaEmpresa> nodito10 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",10));
		GeneralTree<AreaEmpresa> nodo18 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",18));
		GeneralTree<AreaEmpresa> nodo9 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",9));
		GeneralTree<AreaEmpresa> nodo12 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",12));
		GeneralTree<AreaEmpresa> nodo19 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",19));
		
		nodo14.addChild(nodo13);
		nodo14.addChild(nodo25);
		nodo14.addChild(nodo10);
		
		nodo13.addChild(nodo4);
		nodo13.addChild(nodo7);
		nodo13.addChild(nodo5);
		
		nodo25.addChild(nodo6);
		nodo25.addChild(nodito10);
		nodo25.addChild(nodo18);
		
		nodo10.addChild(nodo9);
		nodo10.addChild(nodo12);
		nodo10.addChild(nodo19);
		
		System.out.println("El nivel con mas promedio es:" + devolverMaximoPromedio(nodo14));
	}
}
