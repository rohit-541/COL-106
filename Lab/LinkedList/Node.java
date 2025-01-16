package Lab.LinkedList;

public class Node<T>{
    
    //Properties
    public T value;
    public Node<T> next;
    public Node<T> prev;
    //Constructor
    public Node(T value){
        this.value = value;
        next = null;
        prev= null;
    }
}
