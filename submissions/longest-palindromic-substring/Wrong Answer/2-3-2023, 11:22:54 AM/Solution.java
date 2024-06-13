// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        
        if(len==1)
            return s;
         
        String res ="";
        
        for(int st=0; st<len-1; st++){
            
            for(int ed=len-1; ed>st; ed--){
                
                if(s.charAt(st)==s.charAt(ed)){
                    
                    if(isPal(s.substring(st,ed+1))){
                        
                        if(ed-st+1>res.length())
                            res = s.substring(st,ed+1);
                    }
                }
            }
        }
        
        
        return res;
    }
    
    
    private boolean isPal(String s){
        
        int st=0, ed=s.length()-1;
        
        while(st<=ed){
            if(s.charAt(st)!=s.charAt(ed))
                return false;
            st++;
            ed--;
        }
        
        return true;
    }
}