// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int res = 0;
        
        String str = "";
        boolean sign = false;
        
        String s = String.valueOf(x);
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            res *=10;
            
            if(ch=='-'){
                sign=true;
                continue;
            }
                
            res += Integer.valueOf(ch-'0');
            
            
        }
        
        return sign? -res : res;
    }
}