public class maxSum {
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int currMax = Integer.MIN_VALUE;
    public int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(maxSum(root.left),0);
        int right = Math.max(maxSum(root.right),0);

        this.currMax = Math.max(currMax,root.val+left+right);
        
        return root.val+Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        int result = maxSum(root);
        return Math.max(this.currMax,result);
    }
}