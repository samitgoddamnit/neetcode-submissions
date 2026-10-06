class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length; i++){
            if(i == words.length-1){
                continue;
            }
            if(!valid(words[i],words[i+1],order)){
                return false;
            }
        }
        return true;
    }

    private boolean valid(String a, String b,String order){
        int size = Math.min(a.length(),b.length());
        for(int i = 0; i < size; i ++){
            char a_char = a.charAt(i);
            char b_char = b.charAt(i);
            if(a_char==b_char){
                continue;
            }
            if(order.indexOf(a_char) < order.indexOf(b_char)){
                return true;
            }
            else{
                return false;
            }
        }
        if(a.length() > b.length()){
            return false;
        }
        return true;
    }
}