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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root == null){
            return new LinkedList();
        }
        queue.add(root);
        int size = 1;
        int level = 0;
        while (!queue.isEmpty()){
            int next_size = 0;
            List<Integer> tmp_result = new ArrayList();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                if (tmp.left != null){
                    queue.add(tmp.left);
                    next_size += 1;
                }
                if (tmp.right != null){
                    queue.add(tmp.right);
                    next_size += 1;
                }
                tmp_result.add(tmp.val);
            }
            result.add(tmp_result);
            level += 1;
            size = next_size;
        }
        return result;
    }
}
