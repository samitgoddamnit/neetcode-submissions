class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String,List<String>> map = new HashMap();
        map.put("2", Arrays.asList(new String[] {"a","b","c"}));
        map.put("3", Arrays.asList(new String[] {"d","e","f"}));
        map.put("4", Arrays.asList(new String[] {"g","h","i"}));
        map.put("5", Arrays.asList(new String[] {"j","k","l"}));
        map.put("6", Arrays.asList(new String[] {"m","n","o"}));
        map.put("7", Arrays.asList(new String[] {"p","q","r","s"}));
        map.put("8", Arrays.asList(new String[] {"t","u","v"}));
        map.put("9", Arrays.asList(new String[] {"w","x","y","z"}));
        if(digits.length() == 0){
            return new ArrayList();
        }
        return permutations(digits,map,0,new StringBuilder(),new ArrayList()); 
    }
    
    private List<String> permutations(String digits, HashMap<String,List<String>> map, int i, StringBuilder s, List<String> result){
        if(i == digits.length()){
            result.add(new String(s.toString()));
            return result;
        }
        String digit = Character.toString(digits.charAt(i));
        List<String> options = map.get(digit);
        for(int j = 0; j < options.size(); j++){
            s.append(options.get(j));
            result = permutations(digits,map,i+1,s,result);
            s.deleteCharAt(s.length() - 1);
        }
        return result;
    }
}
