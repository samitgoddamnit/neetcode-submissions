class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        Arrays.fill(cache,-1);
        int tmp = dfs(coins,amount,cache);
        if(tmp == Integer.MAX_VALUE){
            return -1;
        }
        return tmp;
    }

    private int dfs(int[] coins, int amount, int[] cache){
        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        if(cache[amount] != -1){
            return cache[amount];
        }

        if(amount == 0){
            cache[amount] = 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++){
            min = Math.min(dfs(coins,amount - coins[i],cache),min);
        }
        if(min == Integer.MAX_VALUE){
            //this branch is impossible
            cache[amount] = min;
            return min;
        }
        cache[amount] = min + 1;
        return cache[amount];
    }
}
