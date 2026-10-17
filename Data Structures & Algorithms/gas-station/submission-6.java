class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            int net = gas[i] - cost[i];
            total += net;
        }
        if(total < 0){
            return -1;
        }

        //I was closer than I thought !
        int currentFuel = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            int net = gas[i] - cost[i];
            currentFuel = currentFuel + net;
            if(currentFuel < 0){
                currentFuel = 0;
                index = i + 1;
            }
        }
        return index;
    }
}
