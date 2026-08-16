class LRUCache {
    //this took a VERY long time to implement !!!! brush up on doubly linked lists !
    HashMap<Integer,Integer> map;
    Node head;
    Node tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node(-1);
        this.tail = null;
    }
    
    public int get(int key) {
        // System.out.println("called get");
        Integer value = map.get(key);
        // System.out.println("key is "+ key);
        // System.out.println(value);
        // System.out.println(map.keySet());
        if (value != null){
            if (tail.val != key){
                Node previous_node = head;
                while (previous_node.next != null){
                    // System.out.println(previous_node.next.val);
                    if (previous_node.next.val == key){
                        // System.out.println("found the target");
                        // System.out.println(previous_node.next);
                        break;
                    }
                    else{
                        previous_node = previous_node.next;
                    }
                }
                Node target_node = previous_node.next;
                // System.out.println(target_node);
                previous_node.next = target_node.next;
                tail.next = target_node;
                target_node.next = null;
                target_node.prev = tail;
                tail = tail.next;
            }
            // System.out.println(tail.val);
            return value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // System.out.println("called put");
        Integer current_value = map.get(key);
        boolean at_capacity = size == capacity;
        if (current_value != null){
            //exists - need to update that node
            // System.out.println("exists ! reshuffling linked list");
            // System.out.println(value);
            if(tail.val != key){
                Node previous_node = head;
                while (previous_node.next.val != key){
                    previous_node = previous_node.next;
                }
                Node target_node = previous_node.next;
                previous_node.next = target_node.next;
                tail.next = target_node;
                target_node.next = null;
                target_node.prev = tail;
                tail = tail.next;
            }
            map.replace(key,value);
            // System.out.println(tail.val);
        }
        else{
            //doesn't exist - need to make new node
            // System.out.println("doesn't exist so creating new node");
            Node to_add = new Node(key);
            if(at_capacity){
                // System.out.println("at capacity, need to make space");
                // System.out.println(head.next.val);
                map.remove(head.next.val);
                head = head.next;
                size -= 1;
            }
            Node cursor = head;
            while (cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = to_add;
            to_add.prev = cursor;
            tail = to_add;
            map.put(key,value);
            size += 1;
            // System.out.println(head.next.val);
            // System.out.println(tail.val);
            // System.out.println(to_add);
        }
        // System.out.println(map.keySet());
    }
}


class Node{
    int val;
    Node next;
    Node prev;

    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node next,Node prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}