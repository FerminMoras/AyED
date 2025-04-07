package Practica2;

public class Transformacion {
	private BinaryTree<Integer> ab;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.ab = arbol;
	}
	
	public BinaryTree<Integer> getAb() {
		return ab;
	}
	
	public BinaryTree<Integer> suma() {
		transformacionSuma(ab);
		return ab;
	}
	
	private int transformacionSuma(BinaryTree<Integer> ab) {
		int valor = 0;
		
		if(ab.isLeaf()) {
			valor = ab.getData();
			ab.setData(0);
			return valor;
		}
		
		if(ab.hasLeftChild()) {
			valor += transformacionSuma(ab.getLeftChild());
		}
		
		if(ab.hasRightChild()) {
			valor += transformacionSuma(ab.getRightChild());
		}
		
		int actual = ab.getData();
		ab.setData(valor);
		return actual + valor;
	}
	
	public void printPreorden(BinaryTree<Integer> ab) {
		 System.out.println(ab.getData());
		 
		 if (ab.hasLeftChild()) {
			 ab.getLeftChild().printPreorden();
		 }
		 if (ab.hasRightChild()) {
			 ab.getRightChild().printPreorden();
		 }
	}
		
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(2);
		BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(3);
		arbol.addLeftChild(hijoIzq);
		arbol.addRightChild(hijoDer);
		hijoIzq.addRightChild(new BinaryTree<Integer>(4));
		hijoDer.addRightChild(new BinaryTree<Integer>(6));
		BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(5);
		hijoDer.addLeftChild(nodo5);
		nodo5.addLeftChild(new BinaryTree<Integer>(7));
		nodo5.addRightChild(new BinaryTree<Integer>(8));
		
		Transformacion t = new Transformacion(arbol);
		t.suma().printPreorden();
	}
}
