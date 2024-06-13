// https://leetcode.com/problems/split-two-strings-to-make-palindrome

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        
        /*
        
        
        aaa | aaa
        bbb | bbb
        */
        
        int len = a.length();
        
        // apre + bsuf
        
        String revb = new StringBuilder(b).reverse().toString();
        for(int i=0; i<=len; i++){
            
            String suba = a.substring(0, i);
            String subb = revb.substring(0, i);
            String bsuf = revb.substring(i, len-i);
            
            
            if(suba.equals(subb) && isPal(bsuf))
                return true;
        }
        
        // bpre + asuf
        String reva = new StringBuilder(a).reverse().toString();
        for(int i=0; i<=len; i++){
            
            String subb = b.substring(0, i);
            String suba = reva.substring(0, i);
            String asuf = reva.substring(i, len-i);
            
         
            
            if(suba.equals(subb) && isPal(asuf))
                return true;
        }
        
        return false;
        
        
        
    }
    
    private boolean isPal(String s){
        
        for(int i=0; i<s.length()/2; i++){
            
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
               return false;
            
        }
               return true;
        
    }
}