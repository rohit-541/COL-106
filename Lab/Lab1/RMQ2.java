package Lab.Lab1;

public class RMQ2 {

    // Fill the sparse table
    public static void fillLookup(int[] arr, int[][] lookUp, int n) {
        // Base case: fill j=0
        for (int i = 0; i < n; i++) {
            lookUp[i][0] = arr[i];
        }

        // Fill the rest of the sparse table
        //All possible length with power of 2
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                lookUp[i][j] = Math.min(lookUp[i][j - 1], lookUp[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query the sparse table for RMQ
    public static int query(int l, int r, int[][] lookUp) {
        int length = r - l + 1; // Length of the range
        int j = (int) (Math.log(length) / Math.log(2)); // Largest power of 2 that fits
        return Math.min(lookUp[l][j], lookUp[r - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -2, 8, -7};
        int n = nums.length;
        int maxLog = 1 + (int) (Math.log(n) / Math.log(2)); // Maximum power of 2 that fits
        int[][] lookUp = new int[n][maxLog];

        fillLookup(nums, lookUp, n); // Preprocess the sparse table
        int result = query(2, 4, lookUp); // Query range [2, 4]
        System.out.println("Minimum in range [2, 4]: " + result); // Output: -7
    }
}
