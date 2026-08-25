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
        //needed help with memory issues / queue issues. algorithm I got right on my own.
        //used a priority queue to be able to store the max, but I think I could have just
        //passed the max value itself.
        if(node == null){
            return 0;
        }
        path.add(node.val);
        int to_return = dfs(node.left,path) + dfs(node.right,path);
        if(path.peek() <= node.val){
            to_return += 1;
            path.remove(node.val);
            return to_return;
        }
        path.remove(node.val);
        return to_return;
    }
}
