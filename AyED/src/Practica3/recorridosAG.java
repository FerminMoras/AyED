package Practica3;
import java.util.LinkedList;
import java.util.List;
import Practica1.ej8queue;
import Practica3.GeneralTree;

public class recorridosAG {
	
	public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
		
		List<Integer> listaImpares = new LinkedList<Integer>();
		recorrerPreorden(a,n,listaImpares);
		return listaImpares;
	}
	
	private static void recorrerPreorden(GeneralTree <Integer> a, Integer n, List<Integer> listaImpares){
		
		if(a.isEmpty()) {
			return;
		}
		
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
		recorrerPostOrden(a,n,listaImpares);
		return listaImpares;
	}
	
	private static void recorrerPostOrden(GeneralTree <Integer> a, Integer n, List<Integer> listaImpares){
		
		if(a.isEmpty()) {
			return;
		}
		
		if ((a.getData() % 2 != 0) && (a.getData() > n)) {
			listaImpares.add(a.getData());
		}
		
		for (GeneralTree<Integer> hijo: a.getChildren()) {
			recorrerPostOrden(hijo,n,listaImpares);
		}
	}
	 
	 //Recorrido inOrden
	 
	 public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a ,Integer n) {
	        List <Integer> listaImpares = new LinkedList<Integer>();
	       recorrerInOrden(a, n, listaImpares);
	        return listaImpares;
     }
	
	 private static void recorrerInOrden(GeneralTree <Integer> a, Integer n, List<Integer> listaImpares){
		 
		if(a.isEmpty()) {
			return;
		}
		 
	 	List<GeneralTree<Integer>> hijo = a.getChildren();
	 	
        if(a.hasChildren()) {
            recorrerInOrden(hijo.get(0), n, listaImpares);
        }
        
        if((a.getData() %2 != 0) && (a.getData() > n)) { 
        	listaImpares.add(a.getData());
        }	
        
        for(int i=1; i < hijo.size(); i++) {
            recorrerInOrden(a,n, listaImpares);
        }
	 }
	 	
	 
	/*
	
	PREGUNTAR POR COMO IMPLEMENTAR LA QUEUE Y EL INCISO B
	 
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <T> a, Integer n) {
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(a);
        while(!queue.isEmpty()) {
            aux = queue.dequeue();
            if(!aux.isEmpty()) {
                int dato = (Integer) this.getData();
                if(dato %2 != 0 && dato > n) result.add(dato);
            }
            List<GeneralTree<T>> children = aux.getChildren();
            for(GeneralTree<T> child: children) {
                queue.enqueue(child);
            }
        }
        return result;
    }
    
    */
	
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
		
		System.out.println(a.altura());
	}	
}
