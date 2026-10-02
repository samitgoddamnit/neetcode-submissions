class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] cache = new Integer[prices.length][2];
        return dp(prices,cache,0,0);
    }

    private int dp(int[] prices, Integer[][] cache, int bought, int index){
        if(index >= prices.length){
            return 0;
        }

        if(cache[index][bought] != null){
            return cache[index][bought];
        }

        if(bought == 0){
            cache[index][bought] = Math.max(-prices[index] + dp(prices,cache,1,index + 1),dp(prices,cache,0,index + 1));
        }
        else{
            cache[index][bought] = Math.max(+prices[index],dp(prices,cache,1,index + 1));
        }
        return cache[index][bought];
    }
}
