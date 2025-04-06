package Practica2;

import java.util.*;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario (BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public int sumaElementosProfundidad(int nivel) {
		int suma = 0;
		int nivelActual = 0;
		
		Queue<BinaryTree<Integer>> cola = new LinkedList();
 		cola.offer(arbol);
 		
 		while(!cola.isEmpty() && nivelActual <= nivel) {
 			int size = cola.size();
 			
 			for (int i = 0; i < size; i++) {
 	 			BinaryTree<Integer> arbol = cola.poll();
 	 			
 	 			if(nivel == nivelActual) {
 	 				suma += arbol.getData();
 	 			}
 	 			
 	 			else {
 	 				if(arbol.hasLeftChild()) {
 	 					cola.offer(arbol.getLeftChild());
 	 				}
 	 				if(arbol.hasRightChild()) {
 	 					cola.offer(arbol.getRightChild());
 	 				}
 	 			}
 			}
 			nivelActual++;
 		}
 		return suma;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> a1 = new BinaryTree<Integer>(50);
		BinaryTree<Integer> hijoizq = new BinaryTree<Integer>(35);
		hijoizq.addLeftChild(new BinaryTree<Integer>(29));
		hijoizq.addRightChild(new BinaryTree<Integer>(18));
		BinaryTree<Integer> hijoder = new BinaryTree<Integer>(42);
		hijoder.addLeftChild(new BinaryTree<Integer>(7));
		hijoder.addRightChild(new BinaryTree<Integer>(12));
		a1.addLeftChild(hijoizq);
		a1.addRightChild(hijoder);
		
		ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario(a1);
		System.out.println("La suma de los nodos a la profundidad de nivel 2 es: " + p.sumaElementosProfundidad(2));
	}	
}
