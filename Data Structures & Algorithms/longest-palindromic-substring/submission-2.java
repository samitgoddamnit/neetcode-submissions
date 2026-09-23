class Solution {
    public String longestPalindrome(String s) {
        Boolean[][] cache = new Boolean[s.length()][s.length()];
        int best_size = 0;
        String to_return = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                if(palindrome(s,cache,i,j)){
                    if((j - i) > best_size){
                        to_return = s.substring(i,j);
                        best_size = j - i;
                    }
                }
            }
        }
        return to_return;
    }

    private boolean palindrome(String s, Boolean[][] cache, int l, int r){
        int substring_size = r - l;
        
        if(substring_size <= 0){
            return false;
        }
        
        if(cache[l][r-1] != null){
            return cache[l][r-1];
        }

        if(substring_size == 1){
            cache[l][r - 1] = true;
            return true;
        }

        if(substring_size == 2){
            if(s.charAt(l) == s.charAt(r-1)){
                cache[l][r-1] = true;
                return true;
            }
            cache[l][r-1] = false;
            return false;
        }

        if(s.charAt(l) == s.charAt(r-1) && palindrome(s,cache,l+1,r-1)){
            cache[l][r-1] = true;
            return true;
        }
        cache[l][r-1] = false;
        return false;
    }
}
