class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Pair<Integer,Integer>,Integer> cache = new HashMap();
        return dp(nums,target,cache,0);
    }


    private int dp(int[] nums, int target, HashMap<Pair<Integer,Integer>,Integer> cache, int i){
        Pair<Integer,Integer> pair = new Pair<>(target,i);
        if(cache.containsKey(pair)){
            return cache.get(pair);
        }

        if(i >= nums.length){
            if(target == 0){
                cache.put(pair, 1);
                return cache.get(pair);
            }
            cache.put(pair,0);
            return 0;
        }

        cache.put(pair,dp(nums,target + nums[i], cache, i + 1) + dp(nums, target - nums[i], cache, i + 1));
        return cache.get(pair);
    }
}
