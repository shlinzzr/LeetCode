// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        String res="";
        for(int i=0; i<s.length()-1; i++){
                
            String p = extendPalindrome(s, i, i);
            if(p.length()>res.length())
                res = p;
            
            p = extendPalindrome(s, i, i+1);
            if(p.length()>res.length())
                res = p;
        }
        
        return res;
        
        
    }
    
    private String extendPalindrome(String s, int i , int j){
        if(i>0 && j<s.length()-1 && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        
        String p = s.substring(i, j+1);
        return p;
    }
    
    
    
//     private boolean isPalindrome(String s){
        
//         for(int i=0; i<s.length()/2; i++){
            
//             if(s.charAt(i)!=s.charAt(s.length()-i-1)){
//                 return false;
//             }
//         }
        
//         return true;
        
//     }
}