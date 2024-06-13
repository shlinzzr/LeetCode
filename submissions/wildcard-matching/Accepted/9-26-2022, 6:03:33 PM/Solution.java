// https://leetcode.com/problems/wildcard-matching

class Solution {
    public boolean isMatch(String s, String p) {
        
        int i=0; int j=0;
        int starIdx=-1, matchStart=0;
        while(i<s.length()){
            
            if(j<p.length() && (s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')){
                i++;
                j++;
                
            }else if(j<p.length() && p.charAt(j)=='*'){
                starIdx = j;
                matchStart = i;
                j++;
                
            }else if(starIdx!=-1){
                j = starIdx+1;
                i = matchStart+1;
                matchStart = i;
            }else{
                return false;
            }
        }
        
        
        while(j<p.length() && p.charAt(j)=='*')
            j++;
        
        return j==p.length();
    }
}