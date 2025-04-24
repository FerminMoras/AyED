package Practica3;
import java.util.*;

public class Camino {
	private GeneralTree<Integer> arbol;
	
	public Camino(GeneralTree<Integer> a) {
		this.arbol = a;
	}
	
	 public List<Integer> caminoAHojaMasLejana () {
		 List<Integer> caminoMax = new LinkedList<Integer>();
		 List<Integer> caminoAct = new LinkedList<Integer>();
		 if((arbol == null) && (arbol.isEmpty()))
		 	return caminoMax;
		 else {
			 return caminoMasLargo(caminoMax,caminoAct,arbol);
		 }
	 }
	 
	 private List<Integer> caminoMasLargo(List<Integer> max,List<Integer> act, GeneralTree<Integer> a) {
		 act.add(a.getData());
		 
		 if(!a.isLeaf()) {
			 for(GeneralTree<Integer> hijo: a.getChildren()) {
				 caminoMasLargo(max,act,hijo);
			 }
		 }
		 
		 else if (act.size() > max.size()) {
			 max.removeAll(max);
			 max.addAll(act);
		 }
		 
		 act.remove(act.size()-1);
		 
		 return max;
	 }
	 
	 public static void main(String args[]) {
		 	GeneralTree<Integer> nodo12 = new GeneralTree<Integer>(12);
		 	
			GeneralTree<Integer> nodo17 = new GeneralTree<Integer>(17);
			GeneralTree<Integer> nodo9 = new GeneralTree<Integer>(9);
			GeneralTree<Integer> nodo15 = new GeneralTree<Integer>(15);
			
			GeneralTree<Integer> nodo10 = new GeneralTree<Integer>(10);
			GeneralTree<Integer> nodo6 = new GeneralTree<Integer>(6);
			GeneralTree<Integer> nodo8 = new GeneralTree<Integer>(8);
			GeneralTree<Integer> nodo14 = new GeneralTree<Integer>(14);
			GeneralTree<Integer> nodo18 = new GeneralTree<Integer>(18);
			
			GeneralTree<Integer> nodo1 = new GeneralTree<Integer>(1);
			GeneralTree<Integer> nodo16 = new GeneralTree<Integer>(16);
			GeneralTree<Integer> nodo7 = new GeneralTree<Integer>(7);
			
			nodo12.addChild(nodo17);
			nodo12.addChild(nodo9);
			nodo12.addChild(nodo15);
			
			nodo17.addChild(nodo10);
			nodo17.addChild(nodo6);
			
			nodo9.addChild(nodo8);
			
			nodo15.addChild(nodo14);
			nodo15.addChild(nodo18);
			
			nodo6.addChild(nodo1);
			
			nodo14.addChild(nodo16);
			nodo14.addChild(nodo7);
			
			Camino c = new Camino(nodo12);
			
			System.out.println(c.caminoAHojaMasLejana());
	 }
}
