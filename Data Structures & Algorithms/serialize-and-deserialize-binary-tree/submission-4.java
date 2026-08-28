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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        Stack<TreeNode> stack = new Stack();
        HashSet<TreeNode> visited = new HashSet();
        HashSet<TreeNode> printed = new HashSet();
        visited.add(null);
        if(root == null){
            return result;
        }
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(visited.contains(node)){
                stack.pop();
            }
            else{
                boolean hasChildren = node.left != null || node.right != null;
                if(hasChildren){
                    if(!printed.contains(node)){
                        result += Integer.toString(node.val) +"[";
                        printed.add(node);     
                    }
                    if(!visited.contains(node.left)){
                        stack.push(node.left);
                    }
                    else if(!visited.contains(node.right)){
                        result += ",";
                        stack.push(node.right);
                    }
                    else{
                        result += "]";
                        visited.add(node);
                    }
                }
                else{
                    if(!printed.contains(node)){
                        result += Integer.toString(node.val);
                        printed.add(node);
                    }
                    visited.add(node);
                }
            }
        }
        result += "@";
        System.out.println(result);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0){
            return null;
        }

        Stack<TreeNode> stack = new Stack();
        String current = "";
        HashSet<Character> non_number = new HashSet();
        non_number.add(']');
        non_number.add(',');
        non_number.add('[');
        non_number.add('@');

        int k = 0;
        char current_char = data.charAt(k);
        TreeNode dummy = new TreeNode();
        stack.push(dummy);
        // System.out.println(current_char);
        int reading = 0;
        while(current_char != '@'){
            // System.out.println(current_char);
            current = "";
            while (!non_number.contains(current_char)){
                current += current_char;
                k += 1;
                current_char = data.charAt(k);
            }
            TreeNode node = null;
            // System.out.println(stack);
            if(current != ""){
                // System.out.println("making node");
                // System.out.println(current);
                node = new TreeNode(Integer.valueOf(current));
                if(reading == 0){
                    stack.peek().left = node;
                }
                else{
                    stack.peek().right = node;
                }
            }

            if(current_char == '['){
                reading = 0;
                if (node != null){
                    stack.push(node);
                }
            }
            else if(current_char == ','){
                reading = 1;
            }
            else if (current_char == ']'){
                reading = 0;
                stack.pop();
            }
            k += 1;
            current = "";
            if(current_char != '@'){
                current_char = data.charAt(k);
            }
        }
        return dummy.left; 
    }
}
