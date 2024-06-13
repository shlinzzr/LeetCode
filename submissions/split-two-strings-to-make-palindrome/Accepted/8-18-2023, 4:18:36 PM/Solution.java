// https://leetcode.com/problems/split-two-strings-to-make-palindrome

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        
        /*
        aaa | aaa
        bbb | bbb
        */
        
        
        return check(a,b) || check(b,a);
    }
    
    private boolean check(String a, String b){
        int len = a.length();
        int i=0, j=len-1;
        
        while(i<j && a.charAt(i)==b.charAt(j)){
            i++;
            j--;
        }
        if(i>j)
            return true;
        
        
        
        return isPal(a.substring(i, j+1)) || isPal(b.substring(i, j+1));
        
    }
    
    
    private boolean isPal(String s){
        
        for(int i=0; i<s.length()/2; i++){
            
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
               return false;
            
        }
               return true;
        
    }
}