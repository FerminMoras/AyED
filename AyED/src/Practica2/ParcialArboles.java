package Practica2;

public class ParcialArboles {
	private BinaryTree<Integer> ab;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.ab = arbol;
	}
	
	public BinaryTree<Integer> getAb() {
		return this.ab;
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> ab, int num) {
		if(ab.getData() == num) {
			return ab;
		}
		
		BinaryTree<Integer> aux = new BinaryTree<Integer>();
		
		if(ab.hasLeftChild()) {
			aux = buscar(ab.getLeftChild(),num);
		}
		
		if(ab.hasRightChild() && (aux.isEmpty())) {
			aux = buscar(ab.getRightChild(),num);
		}
		
		return aux;
	}
	
	private boolean contar(BinaryTree<Integer> a) {
		int hI = -1;
		int hD = -1;
		if (a.hasLeftChild()) {
			hI = contarUnHijo(a.getLeftChild());
		}
		if(a.hasRightChild()) {
			hD = contarUnHijo(a.getRightChild());
		}
		
		return hI > hD;
	}
	
	private int contarUnHijo(BinaryTree<Integer> a) {
		int cant = 0;
		if (a.hasLeftChild()) {
			cant += contarUnHijo(a.getLeftChild());
		}
		if(a.hasRightChild()) {
			cant += contarUnHijo(a.getRightChild());
		}
		if((a.hasLeftChild() && !a.hasRightChild()) || (!a.hasLeftChild() && a.hasRightChild())) {
			cant++;
		}
		
		return cant;
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> aux = buscar(ab,num);
		if (!aux.isEmpty()) {
			return contar(aux);
		}
		else {
			return false;
		}
			
	}
	
	//EJERCICIO 8
	
	private boolean calcularPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		if (arbol1.getData() != arbol2.getData()) {
			return false;
		}
		
		boolean hI = true;
		boolean hD = true;
		
		if((arbol1.hasLeftChild() && arbol2.hasLeftChild())) {
			hI = calcularPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
		}
		
		if((arbol1.hasRightChild() && arbol2.hasRightChild())) {
			hD = calcularPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
		}
		
		return hI && hD;
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		if (arbol1.isEmpty() || arbol2.isEmpty()) {
			return false;
		}
	
		return calcularPrefijo(arbol1,arbol2);
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
		BinaryTree<Integer> hI = new BinaryTree<Integer>(7);
		BinaryTree<Integer> hD = new BinaryTree<Integer>(-5);
		arbol.addLeftChild(hI);
		arbol.addRightChild(hD);
		
		BinaryTree<Integer> hijo1hD = new BinaryTree<Integer>(19);
		BinaryTree<Integer> hijo1hI = new BinaryTree<Integer>(23);
		BinaryTree<Integer> hijo2hI = new BinaryTree<Integer>(6);
		
		hI.addLeftChild(hijo1hI);
		hI.addRightChild(hijo2hI);
		hD.addLeftChild(hijo1hD);
		
		hijo1hI.addLeftChild(new BinaryTree<Integer>(-3));
		hijo2hI.addLeftChild(new BinaryTree<Integer>(55));
		hijo2hI.addRightChild(new BinaryTree<Integer>(11));
		
		BinaryTree<Integer> nodoUlt = new BinaryTree<Integer>(4);
		hijo1hD.addLeftChild(nodoUlt);
		nodoUlt.addRightChild(new BinaryTree<Integer>(18));
		
		ParcialArboles p = new ParcialArboles(arbol);
	
		System.out.println("Resultado con valor 7: " + p.isLeftTree(7));
		System.out.println("Resultado con valor 2: " + p.isLeftTree(2));
		System.out.println("Resultado con valor -5: " + p.isLeftTree(-5));
		System.out.println("Resultado con valor 19: " + p.isLeftTree(19));
		System.out.println("Resultado con valor -3: " + p.isLeftTree(-3));
		System.out.println("Resultado con valor 22: " + p.isLeftTree(22));
		
		BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> nodo7 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(-5);
		
		arbol2.addLeftChild(nodo7);
		arbol2.addRightChild(nodo5);
		
		nodo7.addRightChild(new BinaryTree<Integer>(6));
		nodo5.addLeftChild(new BinaryTree<Integer>(19));
		
		if (p.esPrefijo(arbol, arbol2)) {
			System.out.println ("Los arboles son prefijos");
		}
		else
			System.out.println ("Los arboles no coinciden");
	}
}