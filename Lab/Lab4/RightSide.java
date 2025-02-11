import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class RightSide {

    public static List<Integer> printRSV(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root ==  null){
            return res;
        }

        Queue<TreeNode> myQ = new LinkedList<>();
        myQ.add(root);

        while(myQ.isEmpty() == false){
            int levelSize = myQ.size();
            int number = -1;
            for(int i =0;i<levelSize;i++){
                TreeNode front = myQ.poll();
                number = front.val;
                if(front.left != null){
                    myQ.offer(front.left);
                }

                if(front.right != null){
                    myQ.offer(front.right);
                }
            }
            res.add(number);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
		int[] preorder = {3,9,20,15,7};
		
		TreeNode root = CreateBT.createBT(inorder,preorder);

        List<Integer> ans = printRSV(root);

        System.out.println(ans);
    }
}
