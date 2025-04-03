package Practica2;

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
	public void entreNiveles(int n, int m){
		BinaryTree<Integer> ab = null;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(this);
		cola.enqueue(null);
			while (!cola.isEmpty()) {
				ab = cola.dequeue();
				if (ab != null) {
					System.out.print(ab.getData());
					if (ab.hasLeftChild()) {
						cola.enqueue(ab.getLeftChild());
					}
					if (ab.hasRightChild()) {
						cola.enqueue(ab.getRightChild());
					}
				}
				else if (!cola.isEmpty()) {
					System.out.println();
					cola.enqueue(null);
		   		}
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
	}
	
}

