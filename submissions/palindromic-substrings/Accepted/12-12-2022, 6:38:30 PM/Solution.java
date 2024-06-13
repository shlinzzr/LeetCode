// https://leetcode.com/problems/palindromic-substrings

class Solution {
    
    int cnt=0;
    public int countSubstrings(String s) {
        
        for(int i=0; i<s.length(); i++){
            
            extend(s, i, i);
            extend(s, i, i+1);
            
        }
        
        
        return cnt;
    }
    
    private void extend(String s, int left, int right){
        
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            cnt++; left--; right++;
        }
        
        
    }
}