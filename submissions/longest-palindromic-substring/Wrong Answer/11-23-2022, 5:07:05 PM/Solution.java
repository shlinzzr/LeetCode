// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        
        String res = "";
        
        
        
        
        for(int i=0; i<len-1; i++){
            
            String odd = extend(s, i, i);
            if(odd.length()>res.length())
                res=odd;
            
            String even = extend(s, i, i+1);
            if(even.length()>res.length())
                res=even;
            
        }
        
        return res;
        
    }
    
    
    private String extend(String s, int i, int j){
        while(i>=0 && j<s.length()-1 && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        
        // System.out.println(s.substring(i+1, j)+ " " + i + " " + j);
        
         return s.substring(i+1, j);
    }
}