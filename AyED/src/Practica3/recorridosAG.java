package Practica3;
import java.util.LinkedList;
import java.util.List;
import Practica1.Queue;
import Practica3.GeneralTree;

public class recorridosAG {
	
	//Recorrido preOrden
	
	public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
		
		List<Integer> listaImpares = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) 
			recorrerPreorden(a,n,listaImpares);
		return listaImpares;
	}
	
	private static void recorrerPreorden(GeneralTree <Integer> a, Integer n, List<Integer> listaImpares){
		
		if ((a.getData() % 2 != 0) && (a.getData() > n)) {
			listaImpares.add(a.getData());
		}
		
		for (GeneralTree<Integer> hijo: a.getChildren()) {
			recorrerPreorden(hijo,n,listaImpares);
		}
	}
	
	
	 //Recorrido postOrden
	 	
	 	public static List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
		
		List<Integer> listaImpares = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty()))
			recorrerPostOrden(a,n,listaImpares);
		return listaImpares;
	}
	
	private static void recorrerPostOrden(GeneralTree <Integer> a, Integer n, List<Integer> listaImpares){
		
		for (GeneralTree<Integer> hijo: a.getChildren()) {
			recorrerPostOrden(hijo,n,listaImpares);
		}
		
		if ((a.getData() % 2 != 0) && (a.getData() > n)) {
			listaImpares.add(a.getData());
		}
		
	}
	 
	 //Recorrido inOrden
	 
	 public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a ,Integer n) {
	        List <Integer> listaImpares = new LinkedList<Integer>();
	        if ((a != null) && (!a.isEmpty()))
	        	recorrerInOrden(a, n, listaImpares);
	        return listaImpares;
     }
	
	 private static void recorrerInOrden(GeneralTree <Integer> a, Integer n, List<Integer> listaImpares){
		 
	 	List<GeneralTree<Integer>> hijo = a.getChildren();
	 	
        if(a.hasChildren()) {
            recorrerInOrden(hijo.get(0), n, listaImpares);
        }
        
        if((a.getData() %2 != 0) && (a.getData() > n)) { 
        	listaImpares.add(a.getData());
        }	
        
        for(int i=1; i < hijo.size(); i++) {
            recorrerInOrden(hijo.get(i),n, listaImpares);
        }
	 }
	 
	//Recorrido porNiveles
	 
	public static List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
        List<Integer> listaImpares = new LinkedList<Integer>();
        if ((a != null) && (!a.isEmpty()))
        	recorrerPorNiveles(a,n,listaImpares);
        return listaImpares;
        
    }
	
	private static void recorrerPorNiveles (GeneralTree<Integer> a, int n, List<Integer> listaImpares) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> treeAux;
		cola.enqueue(a);
		
		while(!cola.isEmpty()) {
			treeAux = cola.dequeue();
			if((treeAux.getData() % 2 != 0) && (treeAux.getData() > n))
				listaImpares.add(treeAux.getData());
			for(GeneralTree<Integer> hijo: treeAux.getChildren()) {
				cola.enqueue(hijo);
			}
		}
		
	}
    
	
	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);childen.add(a2);childen.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
		
		int num = 10;
		
		System.out.println(numerosImparesMayoresQuePreOrden(a,num));
		
		System.out.println(numerosImparesMayoresQuePorNiveles(a,10));
	}	
}
