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
        StringBuilder sb2 = new StringBuilder();
        for(int i=palindrome.length()-1; i>=palindrome.length()/2; i--){
            char c = palindrome.charAt(i);
            
            if(bool==false && c-'a'<26){
                bool=true;
                sb2.insert(0, (char) ('a'+1) );
            }else{
                sb2.insert(0, c);    
            }
            
        }
        
        
        
        return bool==false ? "" : sb.toString()+sb2.toString();
        
    }
}