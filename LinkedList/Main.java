package LinkedList;

public class Main {

    public static LinkedList getList(int n){
        LinkedList list = new LinkedList();
        while(n !=0){
            list.insert(n%10);
            n/=10;
        }

        return list;
    }

    public static String comparision(LinkedList list1,LinkedList list2){
        if(list1.length > list2.length){
            return "Greater";
        }else if(list1.length < list2.length){
            return "Smaller";
        }

        Node temp1 = list1.head;  
        Node temp2 = list2.head;    

        while(temp1 != null && temp2 != null){
            if(temp1.value > temp2.value){
                return "Greater";
            }else if(temp1.value < temp2.value){
                return "Smaller";
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
 
        return "Equal";
    }

    public static void main(String[] args) {
        LinkedList list1 = getList(2345);
        LinkedList list2 = getList(2346);

        
    }
}
