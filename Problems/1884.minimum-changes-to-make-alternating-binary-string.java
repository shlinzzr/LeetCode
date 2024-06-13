// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string

class Solution {
    public int minOperations(String s) {
        int len = s.length();


        int  zeroOne=0, oneZero=0;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(i%2==0){
                if(ch!='0')
                    zeroOne++;
                else 
                    oneZero++;
            }else{
                if(ch!='1')
                    zeroOne++;
                else 
                    oneZero ++;
            }
        }
        return Math.min(zeroOne, oneZero);
    }
}