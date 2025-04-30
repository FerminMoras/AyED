package Practica3;
import java.util.*;
import Practica1.Queue;

public class ParcialArboles2 {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> caminoMax = new LinkedList<Integer>();
		List<Integer> caminoAct = new LinkedList<Integer>();
		if((arbol == null) && (arbol.isEmpty()))
			return caminoMax;
		else 
			return caminoFiltrado(arbol,caminoMax,caminoAct);
	}
	
	private static List<Integer> caminoFiltrado(GeneralTree<Integer> a, List<Integer> max, List<Integer> act) {
		boolean agg = false;
		
		if(a.getData() == 1) {
			act.add(a.getData());
			agg = true;
		}	
		
		if(!a.isLeaf()) {
			for(GeneralTree<Integer> hijos: a.getChildren()) {
				caminoFiltrado(hijos,max,act);
			}
		}
		else if(act.size() > max.size()) {
				max.removeAll(max);
				max.addAll(act);
			}	
		
		if(agg) 
			act.remove(act.size()-1);
		
		
		return max;
	}
	
	public static void main(String args[]) {
		GeneralTree<Integer> nodo1 = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> nodo2 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> nodo3 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo4 = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> nodo5 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo6 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo7 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo8 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> nodo9 = new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> nodo10 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo11 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo12 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo13 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> nodo14 = new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> nodo15 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo16 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> nodo17 = new GeneralTree<Integer>(0);
		
		//NIVEL 0
		nodo1.addChild(nodo2);
		nodo1.addChild(nodo3);
		nodo1.addChild(nodo4);
		
		//NIVEL 1
		nodo2.addChild(nodo5);
		nodo2.addChild(nodo6);
		nodo3.addChild(nodo7);
		nodo3.addChild(nodo8);
		nodo4.addChild(nodo9);
		
		//NIVEL 2
		nodo5.addChild(nodo10);
		nodo5.addChild(nodo11);
		nodo5.addChild(nodo12);
		nodo8.addChild(nodo13);
		nodo9.addChild(nodo14);
		
		//NIVEL 3
		nodo13.addChild(nodo15);
		nodo14.addChild(nodo16);
		nodo14.addChild(nodo17);
		
		System.out.println(resolver(nodo1));
		
	}
}
