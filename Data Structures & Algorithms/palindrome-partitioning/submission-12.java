class Solution {
    public List<List<String>> partition(String s) {
        return backtracking(s,0,1,new ArrayList(),new ArrayList());
    }


    private List<List<String>> backtracking(String s, int i,int j, List<Integer> split_indices,List<List<String>> result){
        if(j == s.length()){
            // System.out.println("at leaf, stack is : " + split_indices);
            int start = 0;
            split_indices.add(s.length());
            List<String> tmp = new ArrayList();
            // System.out.println("before processing leaf, stack is : " + split_indices);
            for (int x = 0; x < split_indices.size(); x++){
                String tmp2 = s.substring(start,split_indices.get(x));
                if(!palindrome(tmp2)){
                    split_indices.remove(split_indices.size()-1);
                    return result;
                }
                start = split_indices.get(x);
                tmp.add(tmp2);
            }
            result.add(tmp);
            split_indices.remove(split_indices.size() - 1);
            return result;
        }
        // System.out.println("before left branch, stack is : " + split_indices);
        if(palindrome(s.substring(i,j))){
            split_indices.add(j);
            result = backtracking(s,j,j+1,split_indices,result);
            split_indices.remove(split_indices.size() - 1);
        }
        // System.out.println("after left branch, stack is : " + split_indices);
        // System.out.println("before right branch, stack is : " + split_indices);
        return backtracking(s,i,j+1,split_indices,result);
        // System.out.println("after right branch, stack is : " + split_indices);
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
