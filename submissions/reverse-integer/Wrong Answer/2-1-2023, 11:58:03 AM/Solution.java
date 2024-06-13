// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int res = 0;
        
        String str = "";
        
        String s = String.valueOf(x);
        boolean sign = s.charAt(0)=='-';
        for(int i=s.length()-1; i>=0; i--){
            
            if(i==0 && sign)
                break;
            
            char ch = s.charAt(i);
            
             System.out.println(ch);
           
            
            res *=10;
            res += Integer.valueOf(ch-'0');
            
            
            
        }
        
        return sign? -res : res;
    }
}