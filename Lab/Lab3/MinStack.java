package Lab3;
import java.util.*;

class MinStack {
    // Declare variable you need
    private Stack<Integer> minStack;
    private Stack<Integer> mainStack;
    // Constructor
    public MinStack() {
        // Initialize variables here
        minStack = new Stack<>();
        mainStack = new Stack<>();
    }

    public void push(int x) {
        //push the x into main stack
        mainStack.push(x);

        //Check if top element of min stack which is current minimum of whole stack is still min or new element is min
        if(minStack.empty() == true){
            minStack.push(x);
        }else{
            //peek of minstack contains current minimum element
            if(minStack.peek() > x){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int element = mainStack.pop();
        
        //check is element is min element then we have to pop that element from min stack
        if(minStack.peek() == element){
            minStack.pop();
        }

    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(2);
        stack.push(7);
        stack.push(5);
        stack.push(9);
        stack.push(1);
        stack.push(0);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.getMin());
    }
}