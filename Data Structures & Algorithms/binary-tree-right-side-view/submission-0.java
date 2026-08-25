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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root == null){
            return new LinkedList();
        }
        int size = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            int tmp_size = 0;
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                    tmp_size += 1;
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                    tmp_size += 1;
                }
                if(size - i == 1){
                    result.add(tmp.val);
                }
            }
            size = tmp_size;
        }
        return result;
    }
}
