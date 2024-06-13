// https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings

class Solution {
    public int maxPalindromes(String s, int k) {
        
        int len = s.length();
        
        int cnt=0;
        
        for(int i=0; i<len; i++){
            
            for(int j=i+k; j<=len; j++){
                
                if(isPal(s.substring(i, j))){
                    cnt++;
                    i=j-1;
                    break;
                }
                    
            }
        }
        
        return cnt;
        
    }
    
    private boolean isPal(String s){
         // System.out.println(s);
        int len = s.length();
        
        int st=0, ed=len-1;
        
        while(st<=ed){
            
            if(s.charAt(st)==s.charAt(ed)){
                st++;
                ed--;
            }else{
                return false;
            }
            
        }
        System.out.println(s);
        return true;
        
        
    }
}