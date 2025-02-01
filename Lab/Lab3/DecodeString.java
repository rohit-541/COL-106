package Lab3;

import java.util.Stack;

public class DecodeString {
    public static Stack<Character> decodeString(String code){
        Stack<Character> st = new Stack<>();

        int i =0;
        while(i < code.length()){
            if(code.charAt(i) == ']'){
                String target = "";
                while(st.peek() != '['){
                    target = st.pop()+target;
                }
                st.pop();
                
                String multiplier = "";
                //till we get integer
                while(st.empty() == false && st.peek() <= '9' && st.peek() >= '0'){
                    multiplier = st.pop()+multiplier;
                }

                int multiple = 1;

                if(multiplier != ""){
                    multiple = Integer.parseInt(multiplier);
                }
                
                for(int j =0;j<multiple;j++){
                    for(int k =0;k<target.length();k++){
                        st.push(target.charAt(k));
                    }
                }
            }else{
                st.push(code.charAt(i));
            }
            i++;


        }
        return st;
    }

    public static void main(String[] args) {
        String code = "13[a200[c]]";
        Stack<Character> st = decodeString(code);
        System.out.println(st);
    }
}
