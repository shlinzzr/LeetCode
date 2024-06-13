// https://leetcode.com/problems/break-a-palindrome

class Solution {
    public String breakPalindrome(String palindrome) {
        StringBuilder sb = new StringBuilder();
        boolean bool = false;
        
        for(int i=0; i<palindrome.length()/2; i++){
            
            char c = palindrome.charAt(i);
            if(bool==false && c-'a'>0){
                bool = true;
                sb.append('a');
            }else{
            
                sb.append(c);                
            }
                
            
        }
        
        for(int i=palindrome.length()/2; i<palindrome.length(); i++){
            char c = palindrome.charAt(i);
            sb.append(c);
        }
        
        
        
        return bool==false ? "" : sb.toString();
        
    }
}