class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        char[] string = s.toCharArray();
        for(int i = 0; i < string.length; i++){
            char character = string[i];
            if(character == '('){
                leftMin += 1;
                leftMax += 1;
            }
            else if (character == ')'){
                leftMin = Math.max(0,leftMin - 1);
                leftMax -= 1;
            }
            else{
                leftMin = Math.max(0,leftMin - 1);
                leftMax += 1;
            }
            if(leftMax < 0){
                return false;
            }
        }
        return leftMin == 0;
    }
}
