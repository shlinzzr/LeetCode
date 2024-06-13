// https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings

class Solution {
    public int maxPalindromes(String s, int k) {
        
        int len = s.length();
        
        int cnt=0;
        
        for(int i=0; i<len; i++){
            
            for(int j=i; j<len; j++){
                
                int wLen=j-i+1;
                if(wLen >k+1) break;
                    
                if( wLen>=k && isPal2(s,i,j)){
                
                // if( isPal(s.substring(i, j))){
                    cnt++;
                    i=j-1;
                    break;
                }
                    
            }
        }
        
        return cnt;
        
    }
    
        boolean isPal2(String s, int l, int r) {
         int or=r, ol=l;
         
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
         
         System.out.println(s.substring(ol, or+1));
         
        return true;
    }
        
    private boolean isPal(String s){
         // System.out.println(s);
        int len = s.length();
        
        int st=0, ed=len-1;
        
        while(st<ed){
            
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