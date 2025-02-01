package Lab1;

public class maxSumArray {

    //Find Max Subaaray Sum
    public static int maxSubarraySum(int[] nums,int n){
        if(n == 0){
            return 0;
        }

        //Find the prefix sum table
        for(int i =1;i<n;i++){
            nums[i]+=nums[i-1];
        }

        int min = 0;
        int maxSum = nums[0];
        for(int i =1;i<n;i++){
            maxSum = Math.max(maxSum, nums[i]-min);
            if(nums[i] < min){
                min = nums[i];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {111126,-1,-1,-1,-1};
        int result = maxSubarraySum(nums, nums.length);

        System.out.println(result);
    }
}