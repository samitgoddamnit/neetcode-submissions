class Solution {
    public int jump(int[] nums) {
        //solution was a BFS using sets of values - dunno how it's really greedy tbh
        
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        int size = 1;
        queue.add(new Pair<Integer,Integer>(0,0));
        while(!queue.isEmpty()){
            int nextSize = 0;
            for(int i = 0; i < size; i++){
                Pair<Integer,Integer> item = queue.poll();
                if(visited.contains(item.getKey())){
                    continue;
                }
                if(item.getKey() == nums.length - 1){
                    return item.getValue();
                }
                for(int j = 1; j <= nums[item.getKey()]; j++){
                    if(!visited.contains(item.getKey() + j)){
                        queue.add(new Pair(item.getKey() + j,item.getValue() + 1));
                    }
                    nextSize += 1;
                }
                visited.add(item.getKey());
            }
            size = nextSize;
        }
        return -1;
    }
}
