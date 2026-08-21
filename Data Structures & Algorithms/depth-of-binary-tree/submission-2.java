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
        Stack<TreeNode> stack = new Stack();
        HashMap<TreeNode,Integer> cache = new HashMap();
        if (root == null){
            return 0;
        }
        cache.put(null,0);
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.peek();
            if (!cache.containsKey(node.left)){
                stack.push(node.left);
            }
            else if (!cache.containsKey(node.right)){
                stack.push(node.right);
            }
            else{
                stack.pop();
                int left_height = cache.get(node.left);
                int right_height = cache.get(node.right);
                cache.put(node,Math.max(left_height,right_height) + 1);
            }
        }
        return cache.get(root);
    }


}
