// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {

        // if(s.length()==1)
        //     return s;
        
        String ans = "";
        
        for(int i=s.length(); i>=0; i--){
            for(int j=0; j<i; j++){

                if(i-j < ans.length())
                    break;
                
                if(isPalindrome(s.substring(j, i))){
                    ans = s.substring(j,i);
                }
            }
        }
        
        return ans;
        
    }
    
    private boolean isPalindrome(String s){
        int st=0, ed=s.length()-1;
        while(st<ed){
            if(s.charAt(st++)!=s.charAt(ed--))
                return false;
        }
        return true;
    }
}