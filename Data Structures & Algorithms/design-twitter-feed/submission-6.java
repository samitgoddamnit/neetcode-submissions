class Twitter {

    HashMap<Integer,HashSet<Integer>> user_following;
    HashMap<Integer,Node> user_posts;
    int timestamp;
    public Twitter() {
        user_following = new HashMap();
        user_posts = new HashMap();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(user_posts.get(userId) == null){
            user_posts.put(userId,new Node(null));
        }
        if(user_following.get(userId) == null){
            user_following.put(userId, new HashSet());
            user_following.get(userId).add(userId);
        }
        Node tmp = user_posts.get(userId);
        Node to_add = new Node(new Pair(tweetId,timestamp));
        tmp.next = to_add;
        to_add.prev = tmp;
        tmp = tmp.next;
        user_posts.replace(userId,tmp);
        timestamp += 1;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        System.out.println(user_following.get(userId));
        Comparator<Node> c = (a,b) -> b.data.getValue() - a.data.getValue();
        PriorityQueue<Node> heap = new PriorityQueue(c);
        Iterator<Integer> itr = user_following.get(userId).iterator();
        while(itr.hasNext()){
            Node tmp = user_posts.get(itr.next());
            if(tmp != null){
                heap.add(tmp);
            }
        }
        ArrayList<Integer> list_to_return = new ArrayList();
        while(list_to_return.size() < 10 && !heap.isEmpty()){
            Node tmp = heap.peek();
            list_to_return.add(tmp.data.getKey());
            tmp = heap.poll();
            if(tmp.prev.data != null){
                heap.add(tmp.prev);
            }
        }
        System.out.println(list_to_return);
        return list_to_return;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            if(user_following.get(followerId) == null){
                user_following.put(followerId, new HashSet());
                user_following.get(followerId).add(followerId);
            }
            user_following.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId){
            if(user_following.get(followerId) == null){
                user_following.put(followerId, new HashSet());
                user_following.get(followerId).add(followerId);
            }
            if(user_following.get(followerId).contains(followeeId)){
                user_following.get(followerId).remove(followeeId);
            }
        }
    }
}

class Node{
    Pair<Integer,Integer> data;
    Node prev;
    Node next;

    public Node(){
        this.data = null;
        this.prev = null;
        this.next = null;
    }

    public Node(Pair<Integer,Integer> data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
