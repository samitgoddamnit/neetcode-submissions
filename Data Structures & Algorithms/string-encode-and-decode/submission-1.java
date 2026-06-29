class Solution {

    public String encode(List<String> strs) {
        String toReturn = "";
        for(String s : strs){
            toReturn = toReturn + s.length() + "|"+ s;
        }
        System.out.println(toReturn);
        return toReturn;
    }

    public List<String> decode(String str) {
        List<String> r = new ArrayList<String>();
        StringBuilder strA = new StringBuilder();
        StringBuilder strB = new StringBuilder(200);
        for(int i = 0; i<str.length();i++){
            do{
                strA.append(str.charAt(i));
                i++;
            }
            while(str.charAt(i) != '|');
            int wLength = Integer.parseInt(strA.toString());
            strA.delete(0,strA.length());
            int wEnd = i + wLength;
            for(int j = i+1; j <= wEnd; j++){
                strB.append(str.charAt(j));
            }
            r.add(strB.toString());
            strB.delete(0,strB.length());
            i = wEnd;
        }
        return r;
    }
}
