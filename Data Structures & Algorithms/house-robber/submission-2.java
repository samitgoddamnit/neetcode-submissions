class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];

        if(cache.length == 1){
            return nums[0];
        }

        if(cache.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        cache[0] = nums[0];
        cache[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            cache[i] = Math.max(cache[i-2] + nums[i],cache[i-1]);
        }
        return cache[cache.length - 1];
    }
}
