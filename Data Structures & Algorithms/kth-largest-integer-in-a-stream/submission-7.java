class KthLargest {
    //reimplemented this using the heap solution, going to watch the video to properly understand it since
    //I'm still not toooo sure why it's like this
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue();
        this.k = k;
        for(int i = 0; i < nums.length; i++){
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
       if(heap.size() < k){
        heap.add(val);
       }
       else if(val > heap.peek()){
         heap.poll();
         heap.add(val);
       }
       return heap.peek();
    }

}
