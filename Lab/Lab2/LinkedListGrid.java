import LinkedList.*;

public class LinkedListGrid{
    public static int middle(Node<Integer> head){

        if(head == null){
            return Integer.MIN_VALUE;
        }

        Node<Integer> fast = head;
        Node<Integer> slow  = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }   

    public static boolean isCycle(Node<Integer> head){
        
        if(head == null){
            return false;
        }

        Node<Integer> fast = head;
        Node<Integer> slow  = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }   

    public static boolean isValid(int[][] grid,int x,int y,int n,int m){
        if(x <0 || y< 0 || x>=n || y>=m){
            return false;
        }

        return true;
    }

    public static boolean isPath(int[][] grid,int n,int m,int x,int y){ 
        //if we are at destignation return true
        if(x == n-1 && y == m-1){
            return true;
        }

        //if we have already stored answer for this them 
        //dplogic

        //mark current cell as visited

        //check moving in all direction 
        //check left
        //if true store ans
        //check right
        //if true store ans
        //check down
        //if true store ans
        //check up 
        //if true store ans
    
        //mark current cell unvisited
        //Time-complexity->O(n^2)
        return false;
    }

    public static void main(String[] args) {
        linkedList<Integer> list = new linkedList<>() ;
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        // list.tail.next = list.head;
        System.out.println(middle(list.head));
        System.out.println(isCycle(list.head));

    }

}
