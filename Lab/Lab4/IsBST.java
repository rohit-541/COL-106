public class IsBST {

    public static boolean isBST(TreeNode root,long min,long max){
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
    }

    
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
		int[] preorder = {3,9,20,15,7};
		
		TreeNode root = CreateBT.createBT(inorder,preorder);

        System.out.println(isBST(root,Long.MIN_VALUE,Long.MIN_VALUE));
    }
}
