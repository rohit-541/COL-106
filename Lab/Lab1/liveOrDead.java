package Lab1;

public class liveOrDead {

    public static boolean isValid(int a,int b,int m,int n){
        if(a<=0 || a>=n || b<=0 || b>=m){
            return false;
        }

        return true;
    }

    //m X n
    public static void stimulateLife(int[][] array,int m,int n){
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                
                int live = 0;
                //Count lives and deads around current index
                for(int a = i-1;a<=i+1;a++){
                    for(int b = j-1;b<=j+1;b++){
                        if(isValid(a,b,m,n) && array[a][b] == 1){
                            live++;
                        }
                    }
                }

                //Decide the state 
                if(array[i][j] == 1 && live < 2){
                    array[i][j] +=10;
                }

                if(array[i][j] == 1 &&(live > 3)){
                    array[i][j] +=10;
                }

                if(array[i][j] == 0 && live == 3){
                    array[i][j] +=10;
                }

            }
        }

        //Fill the array with correct value
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                
                //Change the state 
                if(array[i][j]>1){
                    array[i][j] = array[i][j]%10 == 1?0:1;
                }
            }
        }
    }

    public static void print(int[][] array,int m,int n){
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int m = 9;
        int n = 9;
        int[][] array = {
            {1, 0, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 1, 0, 0, 1, 1, 0, 1, 0},
            {0, 0, 1, 1, 0, 1, 1, 0, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 1, 0, 1, 0},
            {1, 1, 1, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 1, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1}
        };

        stimulateLife(array, m, n);
        print(array, m, n); 
    }
}
