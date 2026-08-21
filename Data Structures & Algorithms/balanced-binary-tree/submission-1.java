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
    public boolean isBalanced(TreeNode root) {
        //height balanced binary tree ?
        //iterative post-order dfs is pretty handy ! lets you process everything 
        //on the left and right before you process the one you're currently on.
        //for something like height, this is really important as you need the heights
        //of the left and right subtrees before you get your own.
        HashMap<TreeNode,Integer> cache = new HashMap();
        Stack<TreeNode> stack = new Stack();
        //this is important !!!! you're setting the height of an empty node.
        //in this convention, the leaf nodes would have a height of one ! 
        // same as asking how many nodes are there from this node inclusive to the leaves.
        
        cache.put(null,0);
        if(root == null){
            return true;
        } 
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(cache.get(node.left) == null){
                stack.push(node.left);
            }
            else if (cache.get(node.right) == null){
                stack.push(node.right);
            }
            else{ 
                int left_height = cache.get(node.left);
                int right_height = cache.get(node.right);
                cache.put(node,Math.max(left_height,right_height) + 1);
                if(Math.abs(left_height - right_height) > 1){
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }
}
