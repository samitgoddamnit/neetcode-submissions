class Solution {
    //correct answer, weird java contains key stuff being wrong.
    //used AI to fix that part, but everything else I got on 
    //my own. Could have used Pair<Integer,<Pair<Integer,Integer>>> instead of Integer[]

    record State(int index, int holding) {}

    public int maxProfit(int[] prices) {
        HashMap<State,Integer> cache = new HashMap();
        return dp(prices,0,0,cache);
    }

    private int dp(int[] prices, int holding, int index,HashMap<State,Integer> cache){
        if(index >= prices.length){
            return 0;
        }

        State state = new State(index,holding);

        if(cache.containsKey(state)){
            return cache.get(state);
        }

        if(holding == 0){
            cache.put(state,Math.max(- prices[index] + dp(prices,1,index + 1,cache),dp(prices,0,index + 1,cache)));
        }
        else{
            cache.put(state,Math.max(prices[index] + dp(prices,0,index + 2,cache),dp(prices,1,index + 1,cache)));
        }
        return cache.get(state);
    }
}
