package Practica2;
import java.util.*;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
		int cant = 0;
		
		if (this.isLeaf()) {
			return 1;
		}
		if(this.hasLeftChild()){
			cant += this.getLeftChild().contarHojas();
		}
		if(this.hasRightChild()){
			cant += this.getRightChild().contarHojas();
		}
		
		return cant;
	}
		
	public void printPreorden() {
		 System.out.println(this.getData());
		 
		 if (this.hasLeftChild()) {
			 this.getLeftChild().printPreorden();
		 }
		 if (this.hasRightChild()) {
			 this.getRightChild().printPreorden();
		 }
	}
	
    	 
    public BinaryTree<Integer> espejo(BinaryTree<Integer> a1) {
    	
    	if(a1 == null) {
    		return null;
    	}
    	
    	BinaryTree<Integer> a2 = new BinaryTree<Integer>(a1.getData());
    	
    	if(a1.hasLeftChild()) {
    		a2.addLeftChild(espejo(a1.getRightChild()));
    	}
    	
    	if(a1.hasRightChild()) {
    		a2.addRightChild(espejo(a1.getLeftChild()));
    	}
    
    	return a2;
	}
    	

	// 0<=n<=m
	public void porNivel(){
		Queue<BinaryTree<T>> cola = new LinkedList();
		cola.offer(this);
		cola.offer(null); //marca nivel
			while (!cola.isEmpty()) { //mientras la cola no este vacia
				BinaryTree<T> ab = cola.poll(); //desencola el primer elemento
				if (ab != null) { //pregunta si es un elemento tipo arbol o si es null llego al final del nivel
					System.out.print(ab.getData());
					if (ab.hasLeftChild()) { //pregunta si tiene hijo izquierdo
						cola.offer(ab.getLeftChild()); //encola hijo izquierdo
					}
					if (ab.hasRightChild()) { //pregunta si tiene hijo derecho
						cola.offer(ab.getRightChild()); //encola hijo derecho
					}
				}
				else if (!cola.isEmpty()) { //pregunta si hay elementos en la cola o si esta vacia
					System.out.println();
					cola.offer(null); //encola null para marcar el nivel
		   		}
			}
	}
	
	public void entreNiveles(int n, int m){
		if((n > m) || (n < 0) || (m < 0) ) {
			System.out.println("Valores de niveles invalidos");
			return;
		}
		
		Queue<BinaryTree<T>> cola = new LinkedList();
		cola.offer(this); //agg el nodo raiz a la cola
		cola.offer(null);
		int nivelActual = n;
		
		while(nivelActual <= m && !cola.isEmpty()) { //mientras ok sea true, y la cola tenga elementos
			//System.out.println("Entra al while");
			int tamaniocola = cola.size(); //obtenemos la cantidad de elementos q hay en la cola
			
			for (int i = 0; i < tamaniocola; i++ ) { //procesamos los elementos del nivel actual
				//System.out.println("Entra al for");
				BinaryTree<T> arbol = cola.poll(); //se desencola el primer nodo y se almacena en el arbol
				System.out.println("Nivel: " + nivelActual);
				System.out.println(arbol.getData()); //imprimimos los nodos del nivel actual
				
				//agregamos los hijos a la cola
				if(arbol.hasLeftChild()) {
					cola.offer(arbol.getLeftChild());
				}
				
				if(arbol.hasRightChild()) {
					cola.offer(arbol.getRightChild());
				}
			}
			nivelActual ++;
		}
		
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
		
		System.out.println("La cantidad de hojas del arbol es: " + a1.contarHojas());
		System.out.println("");
		
		BinaryTree<Integer> a2 = new BinaryTree<Integer>();
		a2 = a1.espejo(a1);
		
		
		System.out.println("Arbol1:");
		a1.printPreorden();
		System.out.println("");
		System.out.println("Arbol2:");
		a2.printPreorden();
		System.out.println("");
		
		ContadorArbol c = new ContadorArbol(a1);
		System.out.println("Ejercicio 3 - Numeros pares recorrido Post Orden: " + c.numerosParesPostOrden());
		System.out.println("");
		System.out.println("Ejercicio 3 - Numeros pares recorrido In Orden: " + c.numerosParesInOrden());
		
		System.out.println("");
		a1.entreNiveles(1,3);
	}
	
}

