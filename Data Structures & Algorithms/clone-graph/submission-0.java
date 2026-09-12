/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return traversal(node, new HashMap());
    }

    private Node traversal(Node node, HashMap<Node,Node> set){
        if(node == null){
            return null;
        }
        Node tmp;
        if(!set.containsKey(node)){
            tmp = new Node();
            tmp.val = node.val;
            set.put(node,tmp);
        }else{
            tmp = set.get(node);
        }
        ArrayList<Node> tmp_neighbour = new ArrayList();
        for(int i = 0; i < node.neighbors.size(); i++){
            if(set.containsKey(node.neighbors.get(i))){
                tmp_neighbour.add(set.get(node.neighbors.get(i)));
            }
            else{
                tmp_neighbour.add(traversal(node.neighbors.get(i),set));
            }
        }
        tmp.neighbors = tmp_neighbour;
        return tmp;
    }
}