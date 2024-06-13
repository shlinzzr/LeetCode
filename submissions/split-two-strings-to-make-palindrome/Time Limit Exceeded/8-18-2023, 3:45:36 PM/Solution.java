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
        for(int i=0; i<=len/2; i++){
            
            String suba = a.substring(0, i);
            String subb = revb.substring(0, i);
            String bmid = revb.substring(i, len-i);
            String amid = a.substring(i, len-i);
            
            
            if(suba.equals(subb) && (isPal(bmid) || isPal(amid)))
                return true;
        }
        
        /*
        
        
"aejbaal flrmkswrydwdkdwdyrwskmrlf qizjezd"
"uvebspq ckawkhbrtlqwblfwzfptanhig laabjea"

*/
        
        // bpre + asuf
        String reva = new StringBuilder(a).reverse().toString();
        for(int i=0; i<=len/2; i++){
            
            String subb = b.substring(0, i);
            String suba = reva.substring(0, i);
            String amid = reva.substring(i, len-i);
            String bmid = b.substring(i, len-i);
         
            if(suba.equals(subb) && (isPal(amid) || isPal(bmid)))
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