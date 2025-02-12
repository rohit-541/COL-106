import java.util.*;

public class kthSmallest {
    
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

    public static void inorder(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }

        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);

    }

    public int kthSmallest(TreeNode root, int k) {
        //Get the inorder and it will be in sorted order then returns

        List<Integer> inOrder = new ArrayList<>();
        inorder(root,inOrder);

        return inOrder.get(k-1);
    }
}