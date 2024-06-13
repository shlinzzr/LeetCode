// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        
        boolean sign = false;
        
        String s = String.valueOf(x); 
        if(s.charAt(0)=='-'){
            sb.append(s.substring(1));
            sign=true;
        }
        else
            sb.append(s);
        
        
        
        return sign? -Integer.valueOf(sb.reverse().toString()) : Integer.valueOf(sb.reverse().toString());
    }
}