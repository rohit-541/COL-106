public class RotateArrayByK {
    
    public static void rotateArray(int[] arr,int k){
        int n = arr.length;
        k = k%n;
        if(k == 0){
            return;
        }
        System.out.println(k);
        int i = 0;
        while(i<n){
            int j = n-k;

            //if j < i then we will disturbed already correct placed item so break out
            if(j<i){
                break;
            }

            //Swap the two numbers
            while(j < n){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }

        //Now solve the rest of array as
        int j = n-1;
        while(i < n){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }

    }

    public static void print(int[] arr){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotateArray(arr, 0);
        print(arr);
    }    
}
