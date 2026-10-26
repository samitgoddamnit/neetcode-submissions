class Solution {
    public boolean checkValidString(String s) {
        //was not able to do this within an hour
        int countLow = 0;
        int countHigh = 0;
        char[] string = s.toCharArray();
        for(int i = 0; i < string.length; i++){
            char c = string[i];
            if(c == '('){
                countLow += 1;
                countHigh += 1;
            }
            else if(c == ')'){
                countLow = Math.max(0,countLow - 1);
                countHigh -= 1;
            }
            else{
                countLow = Math.max(0,countLow - 1);
                countHigh += 1;
            }

            if(countHigh < 0){
                return false;
            }
        }

        return countLow == 0;
    }
}
