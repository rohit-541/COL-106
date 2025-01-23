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

    public static Node<Integer> add(Node<Integer>list1,Node<Integer>list2){
        int carry = 0;
        Node<Integer> temp1 = list1;
        Node<Integer> temp2 = list2;
        Node<Integer> sum = null;
        Node<Integer> temp = sum;
        while(temp1 != null && temp2 != null){
            if(sum == null){
                sum = new Node<>((temp1.value+temp2.value+carry)%10);
                carry = (temp1.value+temp2.value+carry)/10;
                temp = sum;
            }else{
                Node<Integer>newNode = new Node<>((temp1.value+temp2.value+carry)%10);
                carry = (temp1.value+temp2.value+carry)/10;
                temp.next = newNode;
                temp = newNode;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
            System.out.println("Carry: "+carry);
        }

        //list 1 is not empty
        while(carry != 0 && temp1 != null){
            int tempCar = (temp1.value+carry)/10;
            temp1.value = (temp1.value+carry)%10;
            carry = tempCar;
            System.out.println(temp1.value);
            System.out.println("Carry in last: "+carry);
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp1;
        }
        //list 1 is not empty
        while(carry != 0 && temp2 != null){
            temp2.value = (temp2.value+carry)%10;
            carry = (temp2.value+carry)/10;
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp2;
        }

        System.out.println("LastCarry: "+carry);
        temp = sum;
        while(temp.next != null){
            temp = temp.next;
        }
        if(carry != 0){
            temp.next = new Node<>(carry%10);
            carry = carry/10;
            temp = temp.next;
        }

        return sum;
    }

    public static void main(String[] args) {
        //two numbers
        int n1 = 19234;
        int n2 = 923;

        //get the two linked list
        Node<Integer> list1 = getList(n1);
        Node<Integer> list2 = getList(n2);

        System.out.println(compare(list1, list2));

        Node<Integer> sum = add(list1, list2);
        for(Node<Integer> curr = sum;curr != null;curr = curr.next){
            System.out.print(curr.value+" -> ");
        }
        

    }
}
