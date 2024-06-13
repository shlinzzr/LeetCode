// https://leetcode.com/problems/remove-palindromic-subsequences

class Solution {
    public int removePalindromeSub(String s) {
        
        if(s.isEmpty())
            return 0;
        else if( isPalindrome(s))
            return 1;
        else 
            return 2;
        
        
//         int cnt = 0;
        
//         while(s.length()>0){
            
//             for(int i=s.length()-1; i>0; i--){
//                 if( isPalindrome(s.substring(0, i)) )
//                     s=s.substring(0, i);
//             }
//             cnt++;    
//         }
        
//         return cnt;
    }
    
    private boolean isPalindrome(String s){
        
        for(int i=0; i<s.length(); i++){
            if( s.charAt(i) != s.charAt(s.length()-i-1) )
                return false;
        }
        
        return true;
    }
}