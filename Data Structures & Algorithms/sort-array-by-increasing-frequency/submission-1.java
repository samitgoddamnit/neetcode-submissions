class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }
            map.put(nums[i],map.get(nums[i]) + 1);
        }

        List<Pair<Integer,Integer>> list = new ArrayList();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(new Pair(entry.getKey(),entry.getValue()));
        }

        list.sort((a,b) -> {
            if(a.getValue() != b.getValue()){
                return a.getValue() - b.getValue();
            }
            else{
                if(a.getKey() < b.getKey()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            });
        // System.out.println(list);
        // return new int[4];
        List<Integer> result = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            Pair<Integer,Integer> tmp = list.get(i);
            for(int j = 0; j < tmp.getValue();j++){
                result.add(tmp.getKey());
            }
        }
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}