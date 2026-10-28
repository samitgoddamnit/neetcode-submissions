class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] net = new int[gas.length];
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            net[i] = gas[i] - cost[i];
            total += net[i];
        }

        if(total < 0){
            return -1;
        }


        int start = 0;
        int tank = 0;
        

        for(int i = 0; i < net.length; i++){
            tank += net[i];

            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}
