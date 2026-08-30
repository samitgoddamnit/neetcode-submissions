class KthLargest {

    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        //did this via sorting, going to reimplement with a priority queue tomorrow / whenever I get time ig
        this.heap = new PriorityQueue();
        this.k = k;
        // System.out.println(nums.length);
        for(int i = 0; i < nums.length; i++){
            // System.out.println(heap);
            // System.out.println(k);
            if(heap.size() < k){
                heap.add(nums[i]);
            }
            else if (nums[i] > heap.peek()){
                heap.poll();
                heap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        // System.out.println(heap.size());
        // System.out.println(k);
       if(heap.size() < k){
        // System.out.println(val);
        heap.add(val);
       }
       else if(val > heap.peek()){
         heap.poll();
         heap.add(val);
       }
    //    System.out.println(heap.peek());
       return heap.peek();
     // kth largest value is equal to list[length - k]   
    }

}
