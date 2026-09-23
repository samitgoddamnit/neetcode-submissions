class Solution {
    public int countSubstrings(String s) {
        Boolean[][] cache = new Boolean[s.length()][s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                if(palindrome(s,cache,i,j)){
                    count += 1;
                }
            }
        }
        return count;
    }

    private Boolean palindrome(String s, Boolean[][] cache, int l, int r){
        int sub_length = r - l;
        if(r - l < 1){
            return false;
        }

        if(cache[l][r-1] != null){
            return cache[l][r-1];
        }


        if(sub_length == 1){
            cache[l][r-1] = true;
            return true;
        }

        if(sub_length == 2){
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

