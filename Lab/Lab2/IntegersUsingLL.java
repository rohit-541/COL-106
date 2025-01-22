import LinkedList.*;
public class IntegersUsingLL {

    public static Node<Integer> getList(int n){
        linkedList<Integer> list = new linkedList<>();
        while(n!=0){
            list.insert(n%10);
            n/=10;
        }

        return list.head;
    }

    public static int compare(Node<Integer>list1,Node<Integer>list2){

        //-2 if number if of invalid form
        if(list1 == null || list2 == null){
            return -2;
        }

        int l1 =0;
        int l2 = 0;
        for(Node<Integer> tempNode = list1;tempNode!=null;tempNode = tempNode.next){
            l1++;
        }
        for(Node<Integer> tempNode = list2;tempNode!=null;tempNode = tempNode.next){
            l2++;
        }

        //first number is less
        if(l1<l2){
            return 1;
        }else if(l1>l2){
            return -1;
        }

        //start comparing and last number which was larger will be larger

        Node<Integer> temp1 = list1;
        Node<Integer> temp2 = list2;

        //both are equal
        int answer = 0;
        while(temp1 != null){
            if(temp1.value < temp2.value){
                answer = 1;
            }else if(temp1.value> temp2.value){
                answer = -1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }

        return answer;
    }

    public static void main(String[] args) {
        //two numbers
        int n1 = 123;
        int n2 = 123;

        //get the two linked list
        Node<Integer> list1 = getList(n2);
        Node<Integer> list2 = getList(n1);

        System.out.println(compare(list1, list2));



    }
}
