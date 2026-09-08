class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max_l = height[l];
        int max_r = height[r];

        int total = 0;

        while(l<r){
            int val_l = height[l];
            int val_r = height[r];
            max_l = Math.max(val_l,max_l);
            max_r = Math.max(val_r,max_r);
            if(val_l <= val_r){
                total += Math.min(max_l,max_r) - val_l;
                l += 1;
            }
            else{
                total += Math.min(max_l,max_r) - val_r;
                r -= 1;
            }
        }
        return total;
    }
}
