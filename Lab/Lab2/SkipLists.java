import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ListNode{
    int value;
    ListNode next;
    ListNode down;

    public ListNode(int value){
        this.value = value;
        this.next = null;
        this.down = null;
    }
}

public class SkipLists {
    private List<ListNode> levels;
    private Random random;

    public SkipLists(){

        //This will store the Heads of different levels
        this.levels = new ArrayList<>();
        random = new Random();

        //Initialize the list with min value to keep list sorted
        levels.add(new ListNode(Integer.MIN_VALUE));
    }

    //insert a new Node
    public void insert(int value){
        //Start with the topMost level and decend down till base list which is complete list and store the location where we have to add the node 
        //All Previous node whose next element may be our new Element
        List<ListNode> PrevNodes = new ArrayList<>();


        //start from the head of topmost list
        ListNode curr = levels.getLast();

        //Find the correct position for new node in all levels
        while(curr!= null){
            //Tranverse to correct position in current level
            while(curr.next != null && curr.next.value < value){
                curr = curr.next;
            }

            //Store this node 
            PrevNodes.add(curr);
            //Move to lower level
            curr = curr.down;
        }

        //Now we are at lowest level 
        //insert into this which is nessessary always
        //now we will move up with probabily (50%) 
        //so start a loop which should run atleast one time to insert the element in orignal list (complete list)

        //for upper lists we use random check
        //Go up till probabily say us to go or levels get finished
        boolean goUp = true;
        ListNode lowerNode = null;
        while(goUp && !PrevNodes.isEmpty()){
            ListNode prev = PrevNodes.removeLast();
            ListNode newNode = new ListNode(value);
            newNode.next = prev.next;
            prev.next = newNode;

            //Join the lower lists to this if any
            newNode.down = lowerNode;

            //For upper level we have this new Node as connection link instead of prevNode
            lowerNode = newNode;
            
            //Decide wheather we have to move up or not
            goUp = (random.nextInt(2) == 1);
        }

        //If out decider decides to move up but we do not have level then add one
        if(goUp){
            ListNode newHead = new ListNode(Integer.MIN_VALUE);

            //Make a join of newHead with lower list
            newHead.down = levels.getLast();

            //add this list to leveles
            levels.add(newHead);

            //add the element in this list 
            newHead.next = new ListNode(value);
            
            //join this level to lower lists
            newHead.next.down = lowerNode;
        }

    }

    //Search in skiplist
    public boolean Search(int key){
        ListNode current = levels.getLast();
        int i = levels.size()-1;

        while(i>=0){

            //Search in current level
            while(current != null && current.value < key){
                current = current.next;
            }
            //If found return true
            if(current!= null && current.value ==key){
                return true;
            }
            System.out.println("levelNumber: "+i);
            //search in lower level
            if(current != null){
                current = current.down;
            }
            i--;
        }

        return false;
    }

    //Display the list
    public void display(){
        levels.forEach((value)->{
            for(ListNode temp = value;temp!= null;temp = temp.next){
                System.out.print(temp.value+" -> ");
            }
            System.out.println("End");
        });
    }

    public static void main(String[] args) {
        SkipLists skipList = new SkipLists();

        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);
        skipList.display();
        System.out.println(skipList.Search(10));
    }
}


