package Lab1;
import java.util.ArrayList;

public class TupleWithConstraint {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static java.util.List<Pair> mergeArray(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        java.util.List<Pair> mergedArray = new ArrayList<>();

        while (i < A.length || j < B.length || k < C.length) {
            int a = i < A.length ? A[i] : Integer.MAX_VALUE;
            int b = j < B.length ? B[j] : Integer.MAX_VALUE;
            int c = k < C.length ? C[k] : Integer.MAX_VALUE;

            int min = Math.min(a, Math.min(b, c));
            if (min == a) {
                mergedArray.add(new Pair(a, 0));
                i++;
            } else if (min == b) {
                mergedArray.add(new Pair(b, 1));
                j++;
            } else {
                mergedArray.add(new Pair(c, 2));
                k++;
            }
        }
        return mergedArray;
    }

    public static int getTuples(java.util.List<Pair> nums, int d) {
        int start = 0, tuples = 0;
        int Ael = 0, Bel = 0, Cel = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).second == 0) {
                Ael++;
            } else if (nums.get(i).second == 1) {
                Bel++;
            } else {
                Cel++;
            }

            while (nums.get(i).first - nums.get(start).first > d) {
                if (nums.get(start).second == 0) {
                    Ael--;
                } else if (nums.get(start).second == 1) {
                    Bel--;
                } else {
                    Cel--;
                }
                start++;
            }

            if (nums.get(i).second == 0) {
                tuples += Bel * Cel;
            } else if (nums.get(i).second == 1) {
                tuples += Ael * Cel;
            } else {
                tuples += Ael * Bel;
            }
        }

        return tuples;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {1, 2, 4};
        int[] C = {2, 2, 5};

        java.util.List<Pair> mergedList = mergeArray(A, B, C);

        mergedList.forEach((pair) -> {
            System.out.println("first: " + pair.first + ", second: " + pair.second);
        });

        int result = getTuples(mergedList, 1);
        System.out.println("Tuples: " + result);
    }
}
