package Lab1;

public class MaxElement {

    public static int maxElement(int[] nums){
        int max = Integer.MIN_VALUE;

        for(int i =0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,12,10};

        int max = maxElement(nums);
        System.out.println(max);
    }
}
