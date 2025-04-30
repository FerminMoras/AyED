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
		boolean ok = true;
		Queue<GeneralTree<Integer>> cola = new Queue();
		cola.enqueue(arbol);
		while(!cola.isEmpty() && ok) {
			GeneralTree<Integer> aux = cola.dequeue();
			System.out.println("dato AUX " + aux.getData());
			int min = 9999;
			for(GeneralTree<Integer> hijo: aux.getChildren()) {
				cola.enqueue(hijo);
				System.out.println("dato HIJO dentro del for " + hijo.getData());
				min = Math.min(min, hijo.getData());
			}
			System.out.println("dato MINIMO " + min);
			if(!aux.isLeaf() && aux.getData() != min ) {
				ok = false;
			}
		}
		return ok;
	}
	
	public static void main(String args[]) {
		GeneralTree<Integer> nodo12 = new GeneralTree<Integer>(12);
		
		GeneralTree<Integer> nodo13 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> nodo25 = new GeneralTree<Integer>(25);
		
		GeneralTree<Integer> nodo35 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> nodo14 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> nodo26 = new GeneralTree<Integer>(25);
		
		GeneralTree<Integer> nodo36 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> nodo15 = new GeneralTree<Integer>(14);
		GeneralTree<Integer> nodo16 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> nodo33 = new GeneralTree<Integer>(33);
		
		GeneralTree<Integer> nodo37 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> nodo34 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> nodo83 = new GeneralTree<Integer>(83);
		GeneralTree<Integer> nodo90 = new GeneralTree<Integer>(90);
		GeneralTree<Integer> nodo38 = new GeneralTree<Integer>(33);
		
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
		
		System.out.println(esDeSeleccion(nodo12));
	}
}
