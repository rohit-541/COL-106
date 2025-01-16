package Lab.Lab1;

public class SudokuValidator {

    public static boolean isValidSudoko(char[][] board){
        //Validate row 
        for(int i =0;i<9;i++){
            int[] validator = new int[10];
            for(int j =0;j<9;j++){
                int charAtBox = (int)(board[i][j]-'0');
                if(charAtBox !=0){
                    if(validator[charAtBox] != 0){
                        System.out.println(charAtBox);
                        return false;
                    }

                    validator[charAtBox]++;
                }
            }
        }

        //Validate column 
        for(int j =0;j<9;j++){
            int[] validator = new int[10];
            for(int i =0;i<9;i++){
                int charAtBox = (int)(board[i][j]-'0');
                if(charAtBox !=0){
                    if(validator[charAtBox] != 0){
                        System.out.println(charAtBox);
                        return false;
                    }

                    validator[charAtBox]++;
                }
            }
        }

        //Validate Blocks 
        //9->Blocks 
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                //Each of 9 block will be validated here
                int[] validator = new int[10];
                //Validate row 
                for(int a =i*3;a<i*3+3;a++){
                    for(int b =j*3;b<j*3+3;b++){
                        int charAtBox = (int)(board[a][b]-'0');
                        if(charAtBox !=0){
                            if(validator[charAtBox] != 0){
                                return false;
                            }

                            validator[charAtBox]++;
                        }
                    }
                }
            }
        }

        
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','0','0','7','0','0','0','0'},
            {'6','0','0','1','9','5','0','0','0'},
            {'0','9','8','0','0','0','0','6','0'},
            {'8','0','0','0','6','0','0','0','3'},
            {'4','0','0','8','0','3','0','0','1'},
            {'7','0','0','0','2','0','0','0','6'},
            {'0','6','0','0','0','0','2','8','0'},
            {'0','0','0','4','1','9','0','0','5'},
            {'0','0','0','0','8','0','0','7','9'}
        };

        boolean result = isValidSudoko(board);
        System.out.println(result);
    }
    
}   