package LinkedList;

public class LinkedList{
    public Node head;
    public Node tail;
    public int length;
    
    LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public void insert(int value){
        if(this.head == null){
            this.head = new Node(value);
            this.tail = this.head;
        }else{
            this.tail.next = new Node(value);
            this.tail = this.tail.next;
        }
    }

    public void insertReverse(int value){
        if(this.head == null){
            this.head = new Node(value);
        }else{
            Node temp = new Node(value);
            temp.next = this.head;
            head = temp;
        }
        length++;
    }

    public void print(){
        Node temp = this.head;
        System.out.print("Start -> ");
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print(" End");
    }
}
