class Solution {
    public List<List<String>> partition(String s) {
        return backtracking(s,0,1,new ArrayList(),new ArrayList());
    }


    private List<List<String>> backtracking(String s, int i,int j, List<String> substrings,List<List<String>> result){
        if(j == s.length()){
            if(!palindrome(s.substring(i,j))){
                return result;
            }
            substrings.add(s.substring(i,j));
            result.add(new ArrayList(substrings));
            substrings.remove(substrings.size() - 1);
            return result;
        }
        if(palindrome(s.substring(i,j))){
            substrings.add(s.substring(i,j));
            result = backtracking(s,j,j+1,substrings,result);
            substrings.remove(substrings.size() - 1);
        }
        return backtracking(s,i,j+1,substrings,result);
    }


    private boolean palindrome(String s){
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }
}
