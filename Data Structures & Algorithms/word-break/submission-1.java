class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set = new HashSet();
        for(String string : wordDict){
            set.add(string);
        }
        boolean[] cache = new boolean[s.length()];
        Arrays.fill(cache,true);
        return words(s,set,0,cache);

    }

    private boolean words(String s,HashSet<String> set,int i,boolean[] cache){
        if(i == s.length()){
            return true;
        }

        if(!cache[i]){
            return false;
        }

        for (int j = i; j <= s.length(); j++){
            if(set.contains(s.substring(i,j))){
                if(words(s,set,j,cache)){
                    return true;
                }
            }
        }
        cache[i] = false;
        return cache[i];
    }
}
