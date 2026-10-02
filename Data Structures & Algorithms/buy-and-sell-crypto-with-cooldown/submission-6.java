class Solution {
    //correct answer, weird java contains key stuff being wrong.
    //used AI to fix that part, but everything else I got on 
    //my own. Could have used Pair<Integer,<Pair<Integer,Integer>>> instead of Integer[]

    record State(int index, int total, int holding) {}

    public int maxProfit(int[] prices) {
        HashMap<State,Integer> cache = new HashMap();
        return dp(prices,0,0,0,cache);
    }

    private int dp(int[] prices, int total, int holding, int index,HashMap<State,Integer> cache){
        if(index >= prices.length){
            return total;
        }

        State state = new State(index,total,holding);

        if(cache.containsKey(state)){
            // System.out.println("used cache");
            return cache.get(state);
        }

        if(holding == 0){
            cache.put(state,Math.max(dp(prices,total - prices[index],1,index + 1,cache),dp(prices,total,0,index + 1,cache)));
        }
        else{
            cache.put(state,Math.max(dp(prices,total + prices[index],0,index + 2,cache),dp(prices,total,1,index + 1,cache)));
        }
        return cache.get(state);
    }
}
