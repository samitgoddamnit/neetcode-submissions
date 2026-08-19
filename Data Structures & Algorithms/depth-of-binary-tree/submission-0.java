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
    public int maxDepth(TreeNode root) {
        return maxDepthR(root,0);
    }

    public int maxDepthR(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int left_depth = depth ;
        int right_depth = depth ;
        if (root.left != null){
            left_depth = maxDepthR(root.left,depth);
        }
        if (root.right != null){
            right_depth = maxDepthR(root.right,depth);
        }

        return Math.max(left_depth,right_depth) + 1;
    }
}
