class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int longest = 0;
        HashMap<Character,Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(!freq.containsKey(s.charAt(i))){
                freq.put(s.charAt(i),0);
            }
        }
        
        int maxFreq = 0;
        for(int r = 0; r < s.length(); r++){
            freq.put(s.charAt(r),freq.get(s.charAt(r)) + 1);
            maxFreq = Math.max(maxFreq,freq.get(s.charAt(r)));
            while((r - l + 1) - maxFreq > k){
                freq.put(s.charAt(l),freq.get(s.charAt(l)) - 1);
                l += 1;
            }
            longest = Math.max(longest,r-l+1);
        }
        return longest;
    }
}
