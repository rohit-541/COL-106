import LinkedList.*;

public class mergeKsortedList {

    public static Node<Integer> mergeLists(linkedList<Integer>[] array, int start, int end) {
        if (array == null || array.length == 0) return null;
        
        if (start >= end) {
            return array[start].head;
        }

        int mid = (start + end) / 2;

        Node<Integer> left = mergeLists(array, start, mid);
        Node<Integer> right = mergeLists(array, mid + 1, end);

        // Merge the two sorted lists
        Node<Integer> temp1 = left;
        Node<Integer> temp2 = right;

        Node<Integer> dummyHead = new Node<>();
        Node<Integer> currNode = dummyHead;

        while (temp1 != null && temp2 != null) {
            if (temp1.value < temp2.value) {
                currNode.next = temp1;
                temp1 = temp1.next;
            } else {
                currNode.next = temp2;
                temp2 = temp2.next;
            }
            currNode = currNode.next;
        }

        // Append the remaining nodes
        if (temp1 != null) {
            currNode.next = temp1;
        }
        if (temp2 != null) {
            currNode.next = temp2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        linkedList<Integer> list1 = new linkedList<>();
        linkedList<Integer> list2 = new linkedList<>();
        linkedList<Integer> list3 = new linkedList<>();

        list1.insert(1);
        list1.insert(2);
        list1.insert(3);

        list2.insert(3);
        list2.insert(6);

        list3.insert(2);
        list3.insert(7);
        list3.insert(9);

        @SuppressWarnings("unchecked")
        linkedList<Integer>[] lists = new linkedList[]{list1, list2, list3};

        Node<Integer> mergedHead = mergeLists(lists, 0, lists.length - 1);

        // Print the merged list
        while (mergedHead != null) {
            System.out.print(mergedHead.value + " ");
            mergedHead = mergedHead.next;
        }
    }
}
