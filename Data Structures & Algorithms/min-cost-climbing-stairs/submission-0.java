class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];


        cache[0] = cost[0];
        cache[1] = cost[1];
        for(int i = 2; i < cache.length; i++){
            cache[i] = Math.min(cache[i-1],cache[i-2]) + cost[i];
        }
        // System.out.println(Arrays.toString(cache));
        return Math.min(cache[cache.length-1],cache[cache.length-2]);
    }
}
