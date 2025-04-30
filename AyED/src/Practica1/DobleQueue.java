package Practica1;


	public class DobleQueue<T> extends Queue<T> {
	
		public void enqueueFirst(T element) {
			enqueueIndex(0,element); 
		}
	}