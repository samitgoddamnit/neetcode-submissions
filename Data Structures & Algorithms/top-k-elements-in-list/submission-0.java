class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(!frequency.containsKey(nums[i])){
                frequency.put(nums[i],1);
            }
            else{
                frequency.put(nums[i], frequency.get(nums[i]) + 1);
            }
        }
        ArrayList<Map.Entry<Integer,Integer>> output = new ArrayList<>();
        for(Map.Entry<Integer,Integer> x : frequency.entrySet()){
            if(output.size() < k){
                output.add(x);
            }
            else{
                Map.Entry<Integer,Integer> y = x;
                for(int j = 0; j<k;j++){
                    if(y.getValue() > output.get(j).getValue()){
                        Map.Entry<Integer,Integer> temp = output.get(j);
                        output.set(j,y);
                        y = temp;
                    }
                }
            }
        }
        int[] toReturn = new int[k];
        int i = 0;
        for(Map.Entry<Integer,Integer> x : output){
            toReturn[i] = x.getKey();
            i++;
        }
        return toReturn;
    }
}