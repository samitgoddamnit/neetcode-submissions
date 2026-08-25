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
        return dfs(root,new PriorityQueue<>((a,b) -> b - a));
    }

    private int dfs(TreeNode node, PriorityQueue<Integer> path){
        if(node == null){
            return 0;
        }
        // System.out.println(path);
        // System.out.println(node.val);
        path.add(node.val);
        if(path.peek() <= node.val){
            int to_return = dfs(node.left,path) + dfs(node.right,path) + 1;
            path.remove(node.val);
            return to_return;
        }
        int to_return = dfs(node.left,path) + dfs(node.right,path);
        path.remove(node.val);
        return to_return;
    }
}
