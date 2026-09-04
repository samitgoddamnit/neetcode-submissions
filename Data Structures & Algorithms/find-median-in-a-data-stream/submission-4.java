class MedianFinder {
    //do this again in a couple days - solution isn't technically O(log(n)) for addNum but rather O(n) because of the insertion in an
    //array list at a specific index.
    //the solution implemented is the brute force solution.
    ArrayList<Integer> list;
    public MedianFinder() {
        this.list = new ArrayList();
    }
    
    public void addNum(int num) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            int val_m = list.get(m);
            if (val_m <= num){
                l = m + 1;
            }
            else{
                r = m;
            }
        }
        list.add(l,num);
    }
    
    public double findMedian() {
        if(list.size() % 2 == 0){
            double l = list.get(list.size() / 2);
            double r = list.get((list.size() / 2) - 1);
            double result = (l + r)/ 2;
            return result;
        }  
        return (double) list.get(list.size() / 2);
    }
}
