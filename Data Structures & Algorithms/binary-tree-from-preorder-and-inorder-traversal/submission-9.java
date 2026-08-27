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
    int pre_idx = 0;
    HashMap<Integer,Integer> inorder_indexes = new HashMap();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //found this one incredibly hard
        //got a solution working, but has very bad time complexity ahahaha...
        //tests failed due to the time limit
        //time complexity of my solution was n cubed, can get an n solution
        
        //try this again tomorrow I think.

        //ok so I think Java passes things directly rather than by reference ?
        //for some reason when I made the hashmap something you don't pass through my solution got way faster.
        //I implemented the solution using the map (although I think rather than)
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0; i < inorder.length; i++){
            inorder_indexes.put(inorder[i],i);
        }
        return dfs(0,inorder.length);
    }

    private TreeNode dfs(int l, int r){
        if(l >= r){
            return null;
        }
        int root_val = preorder[pre_idx];
        pre_idx += 1;
        TreeNode root = new TreeNode(root_val);
        int split = inorder_indexes.get(root_val);
        root.left = dfs(l,split);
        root.right = dfs(split+1,r);
        return root;
        //biggest speed increase is rewriting it such that you don't pass the root around. The function only creates one node and then searches instead !
    }
}
