class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length; i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i],0);
            }
            map.put(hand[i],map.get(hand[i]) + 1);
        }
        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++){
            if(map.get(hand[i]) == 0){
                continue;
            }
            int current = hand[i];
            map.put(hand[i],map.get(hand[i]) - 1);
            int count = 1;
            while(count < groupSize){
                if(!map.containsKey(current + 1)){
                    return false;
                }
                if(map.get(current+1) <= 0){
                    return false;
                }
                map.put(current + 1,map.get(current+1)- 1);
                current = current + 1;
                count += 1;
            }
        }        
        return true;
    }
}
