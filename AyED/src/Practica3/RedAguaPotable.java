package Practica3;
import java.util.*;

public class RedAguaPotable {
	private GeneralTree<Character> arbol;
	
	public RedAguaPotable (GeneralTree<Character> a) {
		this.arbol = a;
	}
	
	public double minimoCaudal(double caudal) {
		if((arbol == null) && (arbol.isEmpty())) 
			return 0.0;
		else {
			return calcularCaudal(arbol,caudal);
		}	
	}
	
	private double calcularCaudal(GeneralTree<Character> a,double caudal) {
		if(a.isLeaf())
			return caudal;
		
		double cantCaudal = caudal / a.getChildren().size();
		double caudalMin = 9999.00;
		List<GeneralTree<Character>> hijos = a.getChildren();
		for(GeneralTree<Character> hijo: hijos) {
				double caudalHijo = calcularCaudal(hijo,cantCaudal);
				caudalMin = Math.min(caudalMin, caudalHijo);
		}
		
		return caudalMin;
	}

	public static void main (String args[]) {
		//NIVEL 0
		GeneralTree<Character> nodoA = new GeneralTree<Character>('A');
		
		//NIVEL 1
		GeneralTree<Character> nodoB = new GeneralTree<Character>('B');
		GeneralTree<Character> nodoC = new GeneralTree<Character>('C');
		GeneralTree<Character> nodoD = new GeneralTree<Character>('D');
		GeneralTree<Character> nodoE = new GeneralTree<Character>('E');
		
		//NIVEL 2
		GeneralTree<Character> nodoF = new GeneralTree<Character>('F');
		GeneralTree<Character> nodoG = new GeneralTree<Character>('G');
		GeneralTree<Character> nodoH = new GeneralTree<Character>('H');
		GeneralTree<Character> nodoI = new GeneralTree<Character>('I');
		GeneralTree<Character> nodoJ = new GeneralTree<Character>('J');
		GeneralTree<Character> nodoK = new GeneralTree<Character>('K');
		GeneralTree<Character> nodoP = new GeneralTree<Character>('P');
		
		//NIVEL 3
		GeneralTree<Character> nodoL = new GeneralTree<Character>('L');
		GeneralTree<Character> nodoN = new GeneralTree<Character>('M');
		GeneralTree<Character> nodoM = new GeneralTree<Character>('N');
		
		nodoA.addChild(nodoB);
		nodoA.addChild(nodoC);
		nodoA.addChild(nodoD);
		nodoA.addChild(nodoE);
		
		nodoC.addChild(nodoF);
		nodoC.addChild(nodoG);
		
		nodoD.addChild(nodoH);
		nodoD.addChild(nodoI);
		nodoD.addChild(nodoJ);
		nodoD.addChild(nodoK);
		nodoD.addChild(nodoP);
		
		nodoG.addChild(nodoL);
		
		nodoJ.addChild(nodoM);
		nodoJ.addChild(nodoN);
		
		RedAguaPotable red = new RedAguaPotable(nodoA);
		
		System.out.println("El caudal minimo es: " + red.minimoCaudal(1000.00));
	}
}

