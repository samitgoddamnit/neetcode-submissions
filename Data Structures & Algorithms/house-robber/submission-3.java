class Solution { 
    public int rob(int[] nums) { 
        return dfs(0,nums,new int[nums.length]); 
    } 
        
    private int dfs(int i,int[] nums,int[]cache){
        if(i >= nums.length){
            return 0; 
        } 
        if(cache[i] == 0){ 
            cache[i] = Math.max(nums[i] + dfs(i+2,nums,cache),dfs(i+1,nums,cache));
        } 
        return cache[i];
    } 
}