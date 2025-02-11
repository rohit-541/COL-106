public class IsBST {

    public static boolean isBST(TreeNode root){
        if(root == null){
            return true;
        }

        int left = root.left != null?root.left.val:Integer.MIN_VALUE;
        int right = root.right != null?root.right.val:Integer.MAX_VALUE;

        boolean isLeft = isBST(root.left);
        boolean isRight = isBST(root.right);

        return (isLeft && isRight && root.val>=left && root.val < right);
    }

    
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
		int[] preorder = {3,9,20,15,7};
		
		TreeNode root = CreateBT.createBT(inorder,preorder);

        System.out.println(isBST(root));
    }
}
