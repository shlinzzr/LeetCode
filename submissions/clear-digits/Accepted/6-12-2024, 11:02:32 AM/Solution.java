// https://leetcode.com/problems/clear-digits

class Solution {
    public String clearDigits(String s) {
        
        int len  = s.length();
        boolean[] del = new boolean[len];

        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                del[i] = true;

                for(int j=i-1; j>=0; j--){
                    char chj = s.charAt(j);
                    if(!Character.isDigit(chj) && del[j]==false){
                        del[j] = true;
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){

            if(del[i] ==false)
                sb.append(s.charAt(i));

        }

        return sb.toString();
        
    }
}