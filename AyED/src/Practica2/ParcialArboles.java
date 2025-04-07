package Practica2;

public class ParcialArboles {
	private BinaryTree<Integer> ab;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.ab = arbol;
	}
	
	public BinaryTree<Integer> getAb() {
		return this.ab;
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> aux = this.getAb();
		return inciso7(num, aux);
	}
	
	private boolean inciso7(int num, BinaryTree<Integer> aux) {
		
		
	}
}
