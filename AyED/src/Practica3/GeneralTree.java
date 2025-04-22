package Practica3;

import java.util.LinkedList;
import java.util.List;
import Practica1.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		if(this.isEmpty())
			return 0;
		else
			return alturaMax();
	}
	
	private int alturaMax() {
		if(this.isLeaf())
			return 0;
		else {
			int max = -1;
			List<GeneralTree<T>> hijos = this.getChildren();
			for(GeneralTree<T> hijo: hijos) {
				max = Math.max(max, hijo.alturaMax());
			}
			return max + 1; // +1 es por la raiz.
		}
	}
	
	public int nivel(T dato){
		if(this.isEmpty())
			return -1;
		else
			return obtenerNivel(dato);
	  }
	
	private int obtenerNivel(T dato) {
		int cont = 0;
		int act;
		GeneralTree<T> treeAux;
		Queue<GeneralTree<T>> cola = new Queue();
		cola.enqueue(this);
		while(!cola.isEmpty()) {
			act = cola.size();
			for(int i = 0; i < act; i++) {
				treeAux = cola.dequeue();
				if(treeAux.getData() == dato) {
					return cont;
				}
				else {
					for(GeneralTree<T> hijo: treeAux.getChildren()) {
						cola.enqueue(hijo);
					}
				}
			}
			cont++;
		}
		return -1;
	}

	public int ancho(){
		if(this.isEmpty())
			return 0;
		else
			return obtenerAncho();
	}
	
	private int obtenerAncho() {
		int cant = 0;
		int max = -1;
		GeneralTree<T> treeAux;
		Queue<GeneralTree<T>> cola = new Queue();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			treeAux = cola.dequeue();
			if(treeAux != null) {
				List<GeneralTree<T>> hijos = treeAux.getChildren();
				for(GeneralTree<T> hijo: hijos) {
					cola.enqueue(hijo);
					cant++;
				}
			}else if(!cola.isEmpty()) {
				max = Math.max(cant, max);
				cant = 0;
				cola.enqueue(null);
			}
		}
		return max;
	}
	//PREGUNTAR COMO HACERLO.
	public boolean esAncestro(T a, T b) {
		if((this != null) && (this.isEmpty()))
			return false;
		else
			return buscarAncestro(a,b);
	}
	
	private boolean buscarAncestro(T a, T b) {
		return false;
	}
	
	public static void main(String args[]) {
		
		GeneralTree<Integer> nodo0 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> nodo1 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo2 = new GeneralTree<Integer>(2);
		GeneralTree<Integer> nodo3 = new GeneralTree<Integer>(3);
		GeneralTree<Integer> nodo21 = new GeneralTree<Integer>(21);
		GeneralTree<Integer> nodo22 = new GeneralTree<Integer>(22);
		GeneralTree<Integer> nodo23 = new GeneralTree<Integer>(23);
		GeneralTree<Integer> nodo30 = new GeneralTree<Integer>(30);
		GeneralTree<Integer> nodo31 = new GeneralTree<Integer>(31);
		
		nodo0.addChild(nodo1);
		nodo0.addChild(nodo2);
		nodo0.addChild(nodo3);
		
		nodo2.addChild(nodo21);
		nodo2.addChild(nodo22);
		nodo2.addChild(nodo23);
		
		nodo3.addChild(nodo30);
		nodo3.addChild(nodo31);
		
		System.out.println("El nivel del nodo 21 es: " + nodo0.nivel(7));
		
		
	}
}