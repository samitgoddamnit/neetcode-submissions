/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copy = head;
        HashMap<Node,Integer> map = new HashMap<>();
        int index = 0;
        while (copy != null) {
            map.put(copy,index);
            index += 1;
            copy = copy.next;
        }
        map.put(null,-1);

        Node list = head;

        // Node new_head = new Node(0);

        List<Node> array = new ArrayList<Node>();
        for (int i = 0; i < index; i++){
            array.add(null);
        }

        // System.out.println(array);

        for (int i = 0; i < index; i++){
            if (array.get(i) == null){
                // System.out.println("making new node");
                Node tmp = new Node(list.val);
                array.set(i,tmp);
            }

            int order_next = map.get(list.next);
            if (order_next != -1){
                if (array.get(order_next) == null){
                    // System.out.println("making new node for next");
                    Node tmp2 = new Node(list.next.val);
                    array.set(order_next,tmp2);
                }
                array.get(i).next = array.get(order_next);
            }



            int order_random = map.get(list.random);
            if (order_random != -1){
                if (array.get(order_random) == null){
                    // System.out.println("making new node for random");
                    Node tmp3 = new Node(list.random.val);
                    array.set(order_random,tmp3); 
                }
                array.get(i).random = array.get(order_random);
            }
            list = list.next;
        }
        // System.out.println(array.size());
        if (array.size() == 0){
            return null;
        }
        else{
            return array.get(0);
        }
    }
}
