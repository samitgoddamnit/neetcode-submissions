class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> indexes = new HashMap();
        List<List<Integer>> intervals = new ArrayList();
        HashSet<Character> encountered = new HashSet();

        char[] stringChars = s.toCharArray();
        for(int i = 0; i < stringChars.length; i++){
            Character c = stringChars[i];
            if(!encountered.contains(c)){
                encountered.add(c);
                intervals.add(new ArrayList<>(List.of(i,i)));
                indexes.put(c,intervals.size() - 1);
            }
            else{
                intervals.get(indexes.get(c)).set(1,i);
            }
        }

        // System.out.println(intervals);
        //interval merging code is wrong.
        List<Integer> result = new ArrayList();


        HashSet<Integer> ignore = new HashSet();
        int prevItem = 0;
        for(int i = 1; i < intervals.size(); i++){
            List<Integer> prev = intervals.get(prevItem);
            List<Integer> curr = intervals.get(i);
            if(prev.get(1) > curr.get(0)){
                //overlapping
                prev.set(1,Math.max(curr.get(1),prev.get(1)));
                ignore.add(i);
            }
            else{
                prevItem = i;
            }
        }

        // System.out.println(ignore);
        for(int i = 0; i < intervals.size(); i++){
            if(!ignore.contains(i)){
                List<Integer> interval = intervals.get(i);
                result.add(interval.get(1) - interval.get(0) + 1);
            }
        }
        return result;
    }
}
