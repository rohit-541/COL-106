package LinkedList;

public class Node<T>{
    
    //Properties
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(){
        next = null;
        prev = null;
    }

    //Constructor
    public Node(T value){
        this.value = value;
        next = null;
        prev= null;
    }
}
