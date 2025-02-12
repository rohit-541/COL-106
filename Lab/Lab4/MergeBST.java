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

import java.util.*;
class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        //collect all the leaf nodes
        Set<Integer> leafNodes = new HashSet<>();

        for(TreeNode node:trees){
            if(node.left != null){
                leafNodes.add(node.left.val);
            }

            if(node.right != null){
                leafNodes.add(node.right.val);
            }
        }

        //Find the final root of tree
        //root will be one which do not comes as leafnode as all roots which comes as leafnode can be merged into another tree
        TreeNode root = null;
        for(TreeNode node:trees){
            if(!leafNodes.contains(node.val)){
                if(root != null){
                    return null;
                }
                root = node;
            }
        }

        //Create a map of rootValue to treeMap
        Map<Integer,TreeNode> treeMap = new HashMap<>();
        for(TreeNode node:trees){
            if(node != root){
                treeMap.put(node.val,node);
            }
        }

        mergeBST(root,treeMap);

        //check if the created tree is valid or not 
        if(!isValid(root,Long.MIN_VALUE,Long.MAX_VALUE)){
            return null;
        }


        if(!treeMap.isEmpty()){
            return null;
        }

        return root;
    }

    public static boolean isValid(TreeNode root,long min,long max){
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    }


    //Create Tree
    public static void mergeBST(TreeNode root,Map<Integer,TreeNode> treeMap){
        if(root == null){
            return;
        }

        if(root.left != null){
            if(treeMap.containsKey(root.left.val)){
                root.left = treeMap.get(root.left.val);
                treeMap.remove(root.left.val);
            }
        }

        if(root.right != null){
            if(treeMap.containsKey(root.right.val)){
                root.right = treeMap.get(root.right.val);
                treeMap.remove(root.right.val);
            }
        }

        mergeBST(root.left,treeMap);
        mergeBST(root.right,treeMap);
    }


}