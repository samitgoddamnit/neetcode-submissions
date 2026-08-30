class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a,b) -> b - a;
        PriorityQueue<Integer> stoneHeap = new PriorityQueue(c);
        for(int i = 0; i < stones.length; i++){
            stoneHeap.add(stones[i]);
        }

        while (stoneHeap.size() > 1){
            int stoneOne = stoneHeap.poll();
            int stoneTwo = stoneHeap.poll();

            int result = stoneOne - stoneTwo;
            if (result > 0){
                stoneHeap.add(result);
            }
        }

        if (stoneHeap.size() == 1){
            return stoneHeap.peek();
        }
        return 0;

    }
}
