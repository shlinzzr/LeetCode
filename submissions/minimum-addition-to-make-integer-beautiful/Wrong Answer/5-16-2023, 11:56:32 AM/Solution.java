// https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful

class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        String s = String.valueOf(n);
        
        long res = 0;
        
        for(int i=0; i<s.length(); i++){
            if(i==0 && s.charAt(i)-'0' <= target){
                // pass
            }else{
                res = res*10 +  10-(s.charAt(i)-'0');
                
                if(i!=s.length()-1)
                    res--;
            }
            
            
        }
        
        return res;
        
    }
}