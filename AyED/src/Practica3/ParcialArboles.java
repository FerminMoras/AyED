package Practica3;
import Practica1.Queue;

public class ParcialArboles {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if((arbol != null) && (arbol.isEmpty())) {
			return false;
		}else {
			return recorrerSeleccion(arbol);
		}
	}
	
	private static boolean recorrerSeleccion(GeneralTree<Integer> arbol) {
		boolean ok = false;
		Queue<GeneralTree<Integer>> cola = new Queue();
		cola.enqueue(arbol);
		while(!cola.isEmpty() && !ok) {
			GeneralTree<Integer> aux = cola.dequeue();
			
		}
	}
	
	public static void main(String args[]) {
		GeneralTree<Integer> nodo12 = new GeneralTree<Integer>(12);
		
		GeneralTree<Integer> nodo13 = new GeneralTree<Integer>(13);
		GeneralTree<Integer> nodo25 = new GeneralTree<Integer>(25);
		
		GeneralTree<Integer> nodo35 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> nodo14 = new GeneralTree<Integer>(14);
		GeneralTree<Integer> nodo26 = new GeneralTree<Integer>(26);
		
		GeneralTree<Integer> nodo36 = new GeneralTree<Integer>(36);
		GeneralTree<Integer> nodo15 = new GeneralTree<Integer>(15);
		GeneralTree<Integer> nodo16 = new GeneralTree<Integer>(16);
		GeneralTree<Integer> nodo33 = new GeneralTree<Integer>(33);
		
		GeneralTree<Integer> nodo37 = new GeneralTree<Integer>(37);
		GeneralTree<Integer> nodo34 = new GeneralTree<Integer>(34);
		GeneralTree<Integer> nodo83 = new GeneralTree<Integer>(83);
		GeneralTree<Integer> nodo90 = new GeneralTree<Integer>(90);
		GeneralTree<Integer> nodo38 = new GeneralTree<Integer>(38);
		
		nodo12.addChild(nodo13);
		nodo12.addChild(nodo25);
		
		nodo13.addChild(nodo35);
		nodo13.addChild(nodo14);
		nodo25.addChild(nodo26);
		
		nodo35.addChild(nodo36);
		nodo14.addChild(nodo15);
		nodo14.addChild(nodo16);
		nodo14.addChild(nodo33);
		
		nodo36.addChild(nodo37);
		nodo33.addChild(nodo34);
		nodo33.addChild(nodo83);
		nodo33.addChild(nodo90);
		nodo33.addChild(nodo38);
	}
}
