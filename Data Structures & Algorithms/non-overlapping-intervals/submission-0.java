class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Pair<Integer,Integer>> intervals_sorted = new ArrayList();
        for(int i = 0; i < intervals.length; i++){
            intervals_sorted.add(new Pair(intervals[i][0],intervals[i][1]));
        }

        intervals_sorted.sort((a,b) -> a.getKey() - b.getKey());

        // System.out.println(intervals_sorted);

        int total = 0;

        int index = 1;

        while(index < intervals_sorted.size()){
            int left_end = intervals_sorted.get(index-1).getValue();
            int right_start = intervals_sorted.get(index).getKey();
            if(left_end > right_start){
                //overlapping
                int right_end = intervals_sorted.get(index).getValue();
                if(right_end > left_end){
                    intervals_sorted.remove(index);
                }
                else{
                    intervals_sorted.remove(index - 1);
                }
                total += 1;
            }
            else{
                index += 1;
            }
        }

        return total;
    }
}
