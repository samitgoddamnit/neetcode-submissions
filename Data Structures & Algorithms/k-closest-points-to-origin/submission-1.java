class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<Pair<Double,Integer>> c = (a,b) -> Double.compare(a.getKey(),b.getKey());

        PriorityQueue<Pair<Double,Integer>> heap = new PriorityQueue(c);
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            // System.out.println("x = " + x);
            // System.out.println("y = " + y);
            int squared = x * x + y * y;
            // System.out.println("squared = " + squared);
            double distance = Math.sqrt(squared);
            heap.add(new Pair(distance,i));
            // System.out.println(heap);
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            Pair<Double,Integer> item = heap.poll();
            result[i][0] = points[item.getValue()][0];
            result[i][1] = points[item.getValue()][1];
        }
        return result;
    }
}
