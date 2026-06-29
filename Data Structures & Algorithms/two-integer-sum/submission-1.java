class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] answer = {0,0};
        for(int i = 0; i<nums.length; i++){
                map.put(i,nums[i]);
        }
        for(int i = 0; i<nums.length; i++){
            if(map.containsValue(target-nums[i])){
                answer[1] = i;
                for(int j = 0; j<nums.length;j++){
                    if(nums[j] == target-nums[i]){
                        answer[0] = j;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
