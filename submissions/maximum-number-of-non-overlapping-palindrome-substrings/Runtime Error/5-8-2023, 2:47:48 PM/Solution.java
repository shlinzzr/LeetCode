// https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings

class Solution {
    public int maxPalindromes(String s, int k) {
        
        int len = s.length();
        
        int cnt=0;
        
        for(int i=0; i<len; i++){
            
            for(int j=i; j<=len; j++){
                
                
                int wLen = (j-i+1);
                if(wLen >k+1) break;
                    
                if(wLen>=k && isPal(s, i, j)){
                    cnt++;
                    i=j;
                    break;
                }
                    
            }
        }
        
        return cnt;
        
    }
    
     boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}