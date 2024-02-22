// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        
        boolean sign=false;
        if(x<0){
            x=-x;
            sign=true;
        }
        int t=0;
        while(x>0){
            
            if(t>Integer.MAX_VALUE/10 || (t==Integer.MAX_VALUE/10 && x%10>Integer.MAX_VALUE%10))
                return 0;
               
            t= t*10 + x%10;
            x/=10;
        }
        
        return sign ? -t : t;
        
    }
}