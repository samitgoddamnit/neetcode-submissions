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
    public int maxPathSum(TreeNode root) {
        Integer max_total = null;

        Stack<TreeNode> stack = new Stack();
        HashMap<TreeNode,Integer> map = new HashMap();
        map.put(null,0);
        stack.push(root);

        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(!map.containsKey(node.left)){
                stack.push(node.left);
            }
            else if(!map.containsKey(node.right)){
                stack.push(node.right);
            }
            else{
                node = stack.pop();
                // System.out.println("looking at node which has value: " + node.val);
                int left_best = map.get(node.left);
                int right_best = map.get(node.right);
                int both_paths = node.val + left_best + right_best;
                int node_best = Math.max(Math.max(left_best,right_best),0) + node.val;
                map.put(node,node_best);
                // System.out.println("node best is: " + node_best);
                if(max_total == null){
                    max_total = Math.max(node_best,both_paths);
                }
                else{
                    max_total = Math.max(max_total,Math.max(both_paths,node_best));
                }
            }
        }
        return max_total;
    }
}
