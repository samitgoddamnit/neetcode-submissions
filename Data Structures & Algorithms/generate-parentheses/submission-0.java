class Solution {
    public List<String> generateParenthesis(int n) {
        return dfs(n,0,new ArrayList(),new ArrayList(), n*2);
    }

    private List<String> dfs(int n, int unmatched, List<Character> substring, List<String> result, int terminator){
        if(substring.size() == terminator){
            result.add(new String(substring.toString().substring(1,3*substring.size() - 1).replaceAll(", ","")));
            return result;
        }
        // System.out.println(substring);
        if(n > 0){    
            substring.add('(');
            result = dfs(n-1,unmatched + 1,substring,result,terminator);
            substring.remove(substring.size() - 1);
        }
        if (unmatched > 0){
            substring.add(')');
            result = dfs(n,unmatched - 1,substring,result,terminator);
            substring.remove(substring.size() - 1);
        }
        return result;
    }
}
