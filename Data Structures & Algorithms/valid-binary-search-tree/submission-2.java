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
    public boolean isValidBST(TreeNode root) {
        return dst(root,null,null);
    }

    private boolean dst(TreeNode root, Integer lb, Integer ub){
        if(root == null){
            return true;
        }

        if(lb != null && root.val <= lb){
            return false;
        }

        if(ub != null && root.val >= ub){
            return false;
        }
        
        return dst(root.left,lb,root.val) && dst(root.right,root.val,ub);
    }

}
