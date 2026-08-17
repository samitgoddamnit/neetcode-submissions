class LRUCache {

    HashMap<Integer,Node> map;
    Node left;
    Node right;
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        map = new HashMap();
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if (map.get(key) != null){        
            Node node = map.get(key);
            node = remove(node);
            insert(node);
            return node.val;
        }
        else{
            return -1;
        }
    } 
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if (map.get(key) != null){
            Node to_remove = map.get(key);
            remove(to_remove);
            map.remove(key);
        }
        if(map.size() == capacity){
            map.remove(left.next.key);
            remove(left.next);

        }
        insert(node);
        map.put(key,node);
    }

    public Node remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public void insert(Node node){
        Node tmp = right.prev;
        tmp.next = node;
        node.prev = tmp;
        node.next = right;
        right.prev = node;
    }

}


class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public Node(int key, int val, Node next, Node prev){
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

}