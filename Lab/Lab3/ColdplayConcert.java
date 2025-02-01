package Lab3;
import java.util.*;

class ColdplayConcert {

    //Our main target is to find max Length of a sub array such that min(subArray) > threshold/k
    //so we have to store information about a subarray and its minimum

    public static int solve(int[] nums, int threshold) {
        int n = nums.length;
        
        //Using Monotonic stacks for finding next smaller and previous smaller
        
        Stack<Integer> stack = new Stack<>();  

        //We will store the indexes of elements which is next smaller to curr element and prevSmaller to current element so a[i] is smallest in range prevSmaller[i]+1 to nextSmaller[curr]-1;

        int[] nextS = new int[n];              // Next smaller elements
        int[] prevS = new int[n];              // Previous smaller elements
        Arrays.fill(nextS, n);
        Arrays.fill(prevS, -1);

        // Find next smaller elements
        for (int i = 0; i < n; i++) {
            //If top element of stack is larger than current element then its next smaller is current element 
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                nextS[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Clear stack
        stack.clear();

        // Find previous smaller elements
        for (int i = n - 1; i >= 0; i--) {
            //if top element of stack is smaller than current element then it is previous smaller number than this element
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                prevS[stack.pop()] = i;
            }
            stack.push(i);
        }

        //For debugging/////////////////////////////
        System.out.println("Next Array");
        for(int i =0;i<nextS.length;i++){
            System.out.print(nextS[i]+" ");
        }
        System.out.println();

        System.out.println("Prev Array");
        for(int i =0;i<prevS.length;i++){
            System.out.print(prevS[i]+" ");
        }
        System.out.println();
        //For debugging////////////////////////////////


        // Check valid subarray size
        for (int i = 0; i < n; i++) {

            
            int left = prevS[i];     
            
            //Either no next smaller exists then choose whole array 
            int right = nextS[i];
            int len = right - left - 1;          

            if (nums[i] > (threshold / ((double) len))) {
                return len;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,3,1}; 
        int threshold = 8;
        System.out.println(solve(nums, threshold)); // Example call
    }
}
