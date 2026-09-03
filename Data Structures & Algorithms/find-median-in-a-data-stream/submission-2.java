class MedianFinder {
    ArrayList<Integer> list ;

    public MedianFinder() {
        this.list = new ArrayList();
    }
    
    public void addNum(int num) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            int val_m = list.get(m);
            // System.out.println(val_m);
            if (val_m <= num){
                l = m + 1;
            }
            else{
                r = m;
            }
        }
        // System.out.println("adding a number, the index I'll add at is " + l + " and I'm adding " + num);
        list.add(l,num);
        // System.out.println(list);
    }
    
    public double findMedian() {
        if(list.size() % 2 == 0){
            double l = list.get(list.size() / 2);
            double r = list.get((list.size() / 2) - 1);
            // System.out.println(l);
            // System.out.println(r);
            double result = (l + r)/ 2;
            // System.out.println(result);
            return result;
        }  
        else{
            return (double) list.get(list.size() / 2);
        }
    }
}
