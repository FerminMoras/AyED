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
	
    	 
    public BinaryTree<Integer> espejo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
    	if(arbol1.hasLeftChild()){
			arbol2.addRightChild(arbol1.leftChild);
			arbol1.getLeftChild().espejo(arbol1, arbol2);
		}
		if(arbol1.hasRightChild()){
			arbol2.addLeftChild(arbol1.rightChild);
			arbol1.getRightChild().espejo(arbol1, arbol2);
		}
    	
    	
 	   return arbol2;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
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
		
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(a1.getData());
		a1.espejo(a1, a2);
		
		System.out.println("Arbol1:");
		a1.printPreorden();
		System.out.println("Arbol2:");
		a2.printPreorden();
	}
	
}

