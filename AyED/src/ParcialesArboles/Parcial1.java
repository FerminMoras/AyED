package ParcialesArboles;
import Practica2.BinaryTree;
public class Parcial1 {
	private BinaryTree<Integer> arbol;
	
	public Parcial1 (BinaryTree<Integer> ab) {
		this.arbol = ab;
	}
	
	public boolean isTwoTree(int num) {
		if((arbol != null) && (!arbol.isEmpty()))
			return recorrer(arbol,num);
		else
			return false;
	}

	private int contarNodos(BinaryTree<Integer> a) {
		if(a.isLeaf())
			return -1;
		
		int cuenta = 0;
		
		if(a.hasLeftChild() && a.hasRightChild());
			cuenta++;
		
		if(a.hasLeftChild())
			contarNodos(a.getLeftChild());
		
		if(a.hasRightChild())
			contarNodos(a.getRightChild());
	
		return cuenta;
	}
	
	private boolean recorrer(BinaryTree<Integer> a, int num) {
		
		if(a.getData() == num) {
			int HI = -1;
			int HD = -1;
			
			if(a.hasLeftChild())
				HI = contarNodos(a.getLeftChild());
			if(a.hasRightChild())
				HD = contarNodos(a.getRightChild());
			return HI == HD;
		}
		else {
			if(a.hasLeftChild())
				recorrer(a.getLeftChild(),num);
			if(a.hasRightChild())
				recorrer(a.getRightChild(),num);
		}
			
		return false;
	}
}
