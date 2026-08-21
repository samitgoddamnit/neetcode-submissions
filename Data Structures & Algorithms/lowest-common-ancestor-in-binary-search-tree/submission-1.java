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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int p_val = Math.min(p.val,q.val);
        int q_val = Math.max(p.val,q.val);
        //p is always the smaller one, q is always larger
        if (root.left != null && ((q_val < root.val && q_val >= root.left.val) || q_val <= root.left.val)){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if (root.right != null && ((p_val <= root.right.val && root.val < p_val) || p_val >= root.right.val)){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
}
