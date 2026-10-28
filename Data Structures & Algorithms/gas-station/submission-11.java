class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int tank = 0;
        
        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            tank += diff;
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
            total += diff;
        }

        if(total < 0){
            return -1;
        }

        return start;
    }
}
