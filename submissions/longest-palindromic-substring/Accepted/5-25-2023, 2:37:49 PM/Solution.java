// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len==0)
            return "";
        
        int max =1;
        String res = s.charAt(0)+"";
        
        for(int i=0; i<len; i++){
            
            String odd = helper(s, i, i);
            if(odd.length()>res.length())
                res = odd;
            
            if(i+1<len){
                String even = helper(s, i, i+1);
                if(even.length()>res.length())
                    res = even;
            }
            
            
        }
        
        return res;
    }
    
    
    private String helper(String s, int left, int right){
        int len = s.length();
        while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        
        left++;
        right--;
        
        return s.substring(left, right+1);
        
    }
}