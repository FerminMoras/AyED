package Practica1;

public class ej8circularQueue extends ej8queue {
	
	public T shift() {
        T element = dequeue(); // extraigo el último elemento
        enqueue(element); // el último elemento pasa a ser el primero, apuntando así a quien era antes el primer elemento (ahora segundo)
        return element;
    }
}
