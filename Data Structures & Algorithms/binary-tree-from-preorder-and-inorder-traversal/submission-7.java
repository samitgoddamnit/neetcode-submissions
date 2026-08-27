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
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0; i < inorder.length; i++){
            inorder_indexes.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[pre_idx]);
        pre_idx += 1;
        return dfs(preorder,inorder,root,0,inorder.length);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, TreeNode root,int l, int r){
        int split = inorder_indexes.get(root.val);
        if((split <= l) && (r <= split + 1)){
            return root;
        }
        if(split > l){
            TreeNode tmp = new TreeNode(preorder[pre_idx]);
            pre_idx += 1;
            root.left = dfs(preorder,inorder,tmp,l,split);
        }
        if(r > split + 1){
            TreeNode tmp_2 = new TreeNode(preorder[pre_idx]);
            pre_idx += 1;
            root.right = dfs(preorder,inorder,tmp_2,split+1,r);
        }
        return root;
    }
}
