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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findSubRoot(root,subRoot);
    }

    private boolean findSubRoot(TreeNode root, TreeNode subRoot){
        if (root == null){
            return false; 
        }
        else if(root.val == subRoot.val){
            if (sameTree(root,subRoot)){
                return true;
            }
            else{
                return findSubRoot(root.left,subRoot) || findSubRoot(root.right,subRoot);
            }
        }
        else{
            return findSubRoot(root.left,subRoot) || findSubRoot(root.right,subRoot);
        }
    }

    private boolean sameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        else if (p != null && q == null){
            return false;
        }
        else if (p == null && q != null){
            return false;
        }
        else if (p.val != q.val){
            return false;
        }
        else{
            return (sameTree(p.left,q.left) && sameTree(p.right,q.right));
        }
    }
}
