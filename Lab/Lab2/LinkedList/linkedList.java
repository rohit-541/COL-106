package LinkedList;

public class linkedList<T>{
    public Node<T> head;
    public Node<T> tail;
    public int length;
    
    public linkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public void insert(T value){
        if(this.head == null){
            this.head = new Node<>(value);
            this.tail = this.head;
        }else{
            this.tail.next = new Node<>(value);
            this.tail = this.tail.next;
        }
    }

    public void insertReverse(T value){
        if(this.head == null){
            this.head = new Node<>(value);
        }else{
            Node<T> temp = new Node<>(value);
            temp.next = this.head;
            head = temp;
        }
        length++;
    }

    public void print(){
        Node<T> temp = this.head;
        System.out.print("Start -> ");
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print(" End");
    }
}
