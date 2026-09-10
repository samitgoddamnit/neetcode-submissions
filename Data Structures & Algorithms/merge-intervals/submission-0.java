class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        Comparator<int[]> c =  (a,b) -> a[0] - b[0];
        for(int i = 0; i < intervals.length; i++){
            list.add(intervals[i]);
        }
        list.sort(c);
        int index = 1;
        while(index < list.size()){
            if(list.get(index)[0] <= list.get(index - 1)[1]){
                int new_end = Math.max(list.get(index)[1],list.get(index - 1)[1]);
                list.get(index - 1)[1] = new_end;
                list.remove(index);
            }
            else{
                index += 1;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
