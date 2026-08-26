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
        //better solution exists which performs an in-order iterative
        //traversal without using a hashset for storing already visited nodes.
        //there is also another solution that doesn't require a stack. I'll
        //try to implement this solution now.
        int count = 0;
        int result = -1;
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null){
            if(curr.left == null){
                result = curr.val;
                count += 1;
                if(count == k){
                    return result;
                }
                curr = curr.right;
            }
            else{
                prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                    //prev is now predecessor
                }
                if (prev.right == curr){
                    prev.right = null;
                    result = curr.val;
                    count += 1;
                    if(count == k){
                        return result;
                    }
                    curr = curr.right;
                }
                else{
                    prev.right = curr;
                    curr = curr.left;
                }
            }
        }
        return -1;
    }
}
