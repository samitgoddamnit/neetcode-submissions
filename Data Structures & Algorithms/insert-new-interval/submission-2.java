class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        for(int i = 0; i < intervals.length; i++){
            result.add(intervals[i]);
        }
        int l = 0;
        int r = result.size();
        while(l < r){
            int m = l + (r - l) / 2;
            int value = result.get(m)[0];
            if(value <= newInterval[0]){
                l = m + 1;
            }
            else{
                r = m;
            }   
        }
        result.add(l,newInterval);
        //now have everything in sorted order - need to start merging intervals
        int i = 1;
        while(i != result.size()){
            if(result.get(i - 1)[1] >= result.get(i)[0]){
                result.get(i-1)[1] = Math.max(result.get(i)[1],result.get(i-1)[1]);
                result.remove(i);
            }
            else{
                i += 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}