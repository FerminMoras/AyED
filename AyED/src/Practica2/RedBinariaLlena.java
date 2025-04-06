package Practica2;

public class RedBinariaLlena {
	
	public static int retardoEnvio(BinaryTree<Integer> a) {
		int retHI = 0;
		int retHD = 0;
		
		if(a.isEmpty()) {
			return 0;
		}
		
		if(a.hasLeftChild()) {
			retHI = retardoEnvio(a.getLeftChild());
		}
		
		if(a.hasRightChild()) {
			retHD = retardoEnvio(a.getRightChild());
		}
		
		return (Math.max(retHI, retHD) + a.getData());
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
		
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(3);
		arbol.addLeftChild(nodo2);
		arbol.addRightChild(nodo3);
		
		BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(4);
		nodo2.addLeftChild(nodo5);
		nodo2.addRightChild(nodo4);
		
		BinaryTree<Integer> nodo9 = new BinaryTree<Integer>(9);
		BinaryTree<Integer> nodo8 = new BinaryTree<Integer>(8);
		nodo3.addLeftChild(nodo9);
		nodo3.addRightChild(nodo8);
		
		nodo5.addLeftChild(new BinaryTree<Integer>(7));
		nodo5.addRightChild(new BinaryTree<Integer>(8));
		
		nodo4.addLeftChild(new BinaryTree<Integer>(5));
		nodo4.addRightChild(new BinaryTree<Integer>(6));
		
		nodo9.addLeftChild(new BinaryTree<Integer>(12));
		nodo9.addRightChild(new BinaryTree<Integer>(8));
		
		nodo8.addLeftChild(new BinaryTree<Integer>(2));
		nodo8.addRightChild(new BinaryTree<Integer>(1));
		
		System.out.println("El mayor retardo es de: " + retardoEnvio(arbol));
	}
	
}
