class Solution {
    public int rob(int[] nums) {
        int[][] cache = new int[nums.length][2];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(0,nums,1,cache);
    }


    private int dfs(int i, int[] nums,int root, int[][] cache){
        //if invalid
        if(i >= nums.length || (root == 0 && i == nums.length - 1)){
            return 0;
        }


        if(cache[i][root] != -1){
            return cache[i][root];
        }
        
        if(i == 0){
            cache[i][root] = Math.max(nums[i] + dfs(i+2,nums,0,cache),dfs(i+1,nums,1,cache));
        }
        else{
            cache[i][root] = Math.max(nums[i] + dfs(i+2,nums,root,cache),dfs(i+1,nums,root,cache));
        }

        return cache[i][root];
    }
}
