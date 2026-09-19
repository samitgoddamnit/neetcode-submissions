class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //got a solution, but it's very slow... going to watch the video
        //it's technically greedy, but the implementation is poor
        List<Pair<Integer,Integer>> intervals_sorted = new ArrayList();
        for(int i = 0; i < intervals.length; i++){
            intervals_sorted.add(new Pair(intervals[i][0],intervals[i][1]));
        }

        intervals_sorted.sort((a,b) -> a.getKey() - b.getKey());

        // System.out.println(intervals_sorted);

        int total = 0;
        int left_index = 0;
        int right_index = 1;

        while(right_index < intervals_sorted.size()){
            int left_end = intervals_sorted.get(left_index).getValue();
            int right_start = intervals_sorted.get(right_index).getKey();
            if(left_end > right_start){
                //overlapping
                int right_end = intervals_sorted.get(right_index).getValue();
                if(right_end > left_end){
                    right_index += 1;
                }
                else{
                    left_index = right_index;
                    right_index += 1;
                }
                total += 1;
            }
            else{
                left_index = right_index;
                right_index += 1;
            }
        }

        return total;
    }
}
