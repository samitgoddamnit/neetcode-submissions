class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<String,Integer> sh = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            String temp = "" + s.charAt(i);
            if(!sh.containsKey(temp)){
                sh.put(temp,1);
            }
            else{
                sh.put(temp,sh.get(temp) + 1);
            }
        }
        HashMap<String,Integer> th = new HashMap<>();
        for(int i = 0; i<t.length();i++){
            String temp = "" + t.charAt(i);
            if(!th.containsKey(temp)){
                th.put(temp,1);
            }
            else{
                th.put(temp,th.get(temp) + 1);
            }
        }
        if(sh.equals(th)){
            return true;
        }
        return false;
    }
}
