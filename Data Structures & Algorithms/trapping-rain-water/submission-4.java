class Solution {
    public int trap(int[] height) {
        //remembered the prefix solution, didn't get the two pointer solution but remembered how to code
        //up the solution.
        int l = 0;
        int r = height.length - 1;
        int max_l = height[l];
        int max_r = height[r];
        int total = 0;
        while(l<r){
            if(max_l <= max_r){
                l += 1;
                int val_l = height[l];
                int tmp = max_l - val_l;
                total += Math.max(0,tmp);
                max_l = Math.max(max_l,val_l);
            }
            else{
                r -= 1;
                int val_r = height[r];
                int tmp = max_r - val_r;
                total += Math.max(0,tmp);
                max_r = Math.max(max_r,val_r);
            }
        }
        return total;
    }
}
