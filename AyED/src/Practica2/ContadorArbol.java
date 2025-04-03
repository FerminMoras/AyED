package Practica2;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public ArrayList<Integer> numerosParesPostOrden() {
		ArrayList<Integer> vector = new ArrayList<Integer>();
		recorrerPostOrden (arbol,vector);
		return vector;
	}
	
	private void recorrerPostOrden (BinaryTree<Integer> a, ArrayList<Integer> v) {
		if (a.isEmpty()) {
			v.add(0); //si el arbol esta vacio se devuelve 0 en el ArrayList.
		}
		
		if(a.hasLeftChild()) {
			recorrerPostOrden(a.getLeftChild(), v);
		}
		
		if(a.hasRightChild()) {
			recorrerPostOrden(a.getRightChild(),v);
		}
		
		if(a.getData() % 2 == 0) {
			v.add(a.getData());
		}
			
	}
	
	public ArrayList<Integer> numerosParesInOrden() {
		ArrayList<Integer> vector = new ArrayList<Integer>();
		recorrerInOrden (arbol,vector);
		return vector;
	}
	
	private void recorrerInOrden (BinaryTree<Integer> a, ArrayList<Integer> v) {
		if (a.isEmpty()) {
			v.add(0); //si el arbol esta vacio se devuelve 0 en el ArrayList.
		}
		
		if(a.hasLeftChild()) {
			recorrerPostOrden(a.getLeftChild(), v);
		}
		
		if(a.getData() % 2 == 0) {
			v.add(a.getData());
		}
		
		if(a.hasRightChild()) {
			recorrerPostOrden(a.getRightChild(),v);
		}
			
	}
}
