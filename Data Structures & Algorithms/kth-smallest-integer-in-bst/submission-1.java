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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        HashSet<TreeNode> set = new HashSet();
        TreeNode result = null;
        int count = 0;
        stack.push(root);
        while(!stack.empty()){
            // System.out.println(stack);
            TreeNode node = stack.peek();
            if(node.left != null && !set.contains(node.left)){
                stack.push(node.left);
            }
            else{
                result = stack.pop();
                set.add(result);
                // System.out.println(result);
                count += 1;
                if(count == k){
                    return result.val;
                }
                if (node.right != null && !set.contains(node.right)){
                    stack.push(node.right);
                }
            }
        }
        return -1;
    }
}
