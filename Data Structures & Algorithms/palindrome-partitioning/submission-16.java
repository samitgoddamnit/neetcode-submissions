class Solution {
    public List<List<String>> partition(String s) {
        return backtracking(s,0,1,new ArrayList(),new ArrayList());
    }


    private List<List<String>> backtracking(String s, int i,int j, List<Integer> split_indices,List<List<String>> result){
        if(j == s.length()){
            if(!palindrome(s.substring(i,j))){
                return result;
            }
            int start = 0;
            split_indices.add(j);
            List<String> tmp = new ArrayList();
            for (int x = 0; x < split_indices.size(); x++){
                String tmp2 = s.substring(start,split_indices.get(x));
                start = split_indices.get(x);
                tmp.add(tmp2);
            }
            result.add(tmp);
            split_indices.remove(split_indices.size() - 1);
            return result;
        }
        System.out.println(s.substring(i,j));
        if(palindrome(s.substring(i,j))){
            split_indices.add(j);
            result = backtracking(s,j,j+1,split_indices,result);
            split_indices.remove(split_indices.size() - 1);
        }
        return backtracking(s,i,j+1,split_indices,result);
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
