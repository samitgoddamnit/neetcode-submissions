class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        Integer[] cache = new Integer[n];
        cache[0] = 1;
        cache[1] = 2;
        for(int i = 0; i < n; i++){
            if(cache[i] == null){
                cache[i] = cache[i - 1] + cache[i - 2];
            }
        }
        return cache[n - 1];
    }
}
