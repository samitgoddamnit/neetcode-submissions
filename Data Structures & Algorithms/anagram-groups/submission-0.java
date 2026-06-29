class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<String,Integer>,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            HashMap<String,Integer> temp = generateFrequencyMap(strs[i]);
            if(!map.containsKey(temp)){
               List<String> dummy = new ArrayList<>();
               map.put(temp,dummy);
            }
            map.get(temp).add(strs[i]);
        }
        List<List<String>> grouped = new ArrayList<>();
        for(List<String> x : map.values()){
            grouped.add(x);
        }
        return grouped;
    }


    public HashMap<String,Integer> generateFrequencyMap(String s){
        HashMap<String,Integer> strF = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            String temp = "" + s.charAt(i);
            if(!strF.containsKey(temp)){
                strF.put(temp,1);
            }
            else{
                strF.put(temp,strF.get(temp) + 1);
            }
        }
        return strF;
    }
        
}
