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
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }

    private int dfs(TreeNode node,Integer current_max){
        //needed help with memory issues / queue issues. algorithm I got right on my own.
        //used a priority queue to be able to store the max, but I think I could have just
        //passed the max value itself.


        //implemented the other method, runtime is still low but eh
        if(node == null){
            return 0;
        }
        
        if(node.val >= current_max){
            int tmp = Math.max(node.val,current_max);
            return dfs(node.left,tmp) + dfs(node.right,tmp) + 1;
        }
        return dfs(node.left,current_max) + dfs(node.right,current_max);
    }
}
