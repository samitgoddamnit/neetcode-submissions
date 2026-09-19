/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Comparator<Interval> c = (a,b) -> a.end - b.end;
        PriorityQueue<Interval> heap = new PriorityQueue(c);
        intervals.sort((a,b) -> a.start - b.start);
        int max_size = 0;
        for(int i = 0; i < intervals.size(); i++){
            while(!heap.isEmpty() && intervals.get(i).start >= heap.peek().end){
                heap.poll();
            }
            heap.add(intervals.get(i));
            max_size = Math.max(heap.size(),max_size);
        }
        return max_size;
    }
}
