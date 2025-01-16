package Lab.Lab1;

public class RMQ {

    // Preprocess the array to build the sparse table
    public static int[][] preprocess(int[] array) {
        int n = array.length;
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1; // Number of columns in the sparse table
        int[][] lookUp = new int[n][maxLog];

        // Initialize the first column with array values (interval size = 1)
        for (int i = 0; i < n; i++) {
            lookUp[i][0] = array[i];
        }

        // Fill the table for larger intervals
        for (int j = 1; (1 << j) <= n; j++) { // j represents log(range length)
            for (int i = 0; i + (1 << j) - 1 < n; i++) { // i is the start index
                lookUp[i][j] = Math.min(lookUp[i][j - 1], lookUp[i + (1 << (j - 1))][j - 1]);
            }
        }

        return lookUp;
    }

    // Query the minimum value in the range [L, R]
    public static int query(int[][] lookUp, int L, int R) {
        int rangeLength = R - L + 1;
        int j = (int) (Math.log(rangeLength) / Math.log(2)); // Largest power of 2 that fits in the range
        return Math.min(lookUp[L][j], lookUp[R - (1 << j) + 1][j]);
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] nums = {1, 3, -2, 8, -7};
        int[][] lookUp = preprocess(nums);

        // Test queries
        System.out.println("Minimum in range [1, 3]: " + query(lookUp, 1, 3)); // Expected: -2
        System.out.println("Minimum in range [0, 4]: " + query(lookUp, 0, 4)); // Expected: -7
        System.out.println("Minimum in range [2, 2]: " + query(lookUp, 2, 2)); // Expected: -2
    }
}
