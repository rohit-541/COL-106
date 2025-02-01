package Lab3;
import java.util.*;

class MyQueue {
    private Stack<Integer> stack1; // For enqueue
    private Stack<Integer> stack2; // For dequeue
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void enqueue(int x) {
        stack1.push(x);
    }
    
    public void dequeue() {
        if(stack2.empty() == true){
            transferElements();
        }

        stack2.pop();
    }
    
    public int front() {
        // Your code here
        if(stack2.empty() == true){
            transferElements();
        }

        return stack2.peek();
    }
    
    public boolean isEmpty() {
        return stack1.empty() && stack2.empty(); 
    }
    
    // Optional: Helper method for transferring elements
    private void transferElements() {
        while(stack1.empty() == false){
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        myQueue.enqueue(7);

        while(myQueue.isEmpty() == false){
            System.out.println(myQueue.front());
            myQueue.dequeue();
        }
    }
}

