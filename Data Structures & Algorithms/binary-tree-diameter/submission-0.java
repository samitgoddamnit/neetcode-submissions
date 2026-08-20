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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        int max_depth = recursiveDepth(root,0);
        
        return diameter;
    }

    public int recursiveDepth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }

        int left_depth = recursiveDepth(root.left,depth);
        int right_depth = recursiveDepth(root.right,depth);

        if (left_depth + right_depth > diameter){
            diameter = left_depth + right_depth;
        }

        return Math.max(left_depth,right_depth) + 1;
    }
}

class NodeDepth {
    TreeNode node;
    int depth;

    public NodeDepth(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}