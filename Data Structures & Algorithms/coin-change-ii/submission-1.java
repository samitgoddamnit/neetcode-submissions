class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] cache = new Integer[amount+1][coins.length];
        return dp(amount,coins,cache,0);
    }


    private int dp(int amount, int[] coins, Integer[][] cache, int i){
        if(i >= coins.length){
            return 0;
        }
       
        if(amount < 0){
            return 0;
        }
        if(cache[amount][i] != null){
            return cache[amount][i];
        }

        if(amount == 0){
            cache[amount][i] = 1;
            return cache[amount][i];
        }


        cache[amount][i] = dp(amount - coins[i],coins,cache,i) + dp(amount,coins,cache,i+1);
        return cache[amount][i];
    }
}
