class Solution {
    public int jump(int[] nums) {
        //solution was a BFS using sets of values - dunno how it's really greedy tbh
        //ok how I implemented it it's O(n^2), need to look at the actual greedy solution it looks like
        // going to implement this properly, visit this tomorrow

        int l = 0;
        int r = 0;
        int furthest = 0;
        int result = 0;
        while(r < nums.length - 1){
            for(int i = l; i <= r; i++){
                furthest = Math.max(furthest, nums[i] + i);
            }
            l = r + 1;
            r = furthest;
            result += 1;
        }
        return result;
    }
}
