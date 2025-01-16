package Lab.Lab1;

public class isSorted {

    public static boolean isSortedArray(int[] nums){
        

        for(int i =1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,5};

        boolean isSorted = isSortedArray(nums);
        System.out.println(isSorted);
    }    
}
