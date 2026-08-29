class KthLargest {

    ArrayList<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        this.list = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int l = 0;
            int r = list.size();
            while (l < r){
                int m = l + (r - l) / 2;
                // System.out.println(m);
                int mid = list.get(m);
                if(nums[i] <= mid){
                    r = m;
                }
                else{
                    l = m + 1;
                }
            }
            list.add(l,nums[i]);
        }
        this.k = k;
    }
    
    public int add(int val) {
        int l = 0;
        int r = list.size();
        while (l < r){
            int m = l + (r - l) / 2;
            int mid = list.get(m);
            if(val <= mid){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        list.add(l,val);
        int index = list.size()-k;
        if(list.size() <= k){
            return list.get(0);
        }
        return list.get(index);
     // kth largest value is equal to list[length - k]   
    }

}
