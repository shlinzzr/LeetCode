// https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        String prev= null;
        int t=0;
        
        while(s.indexOf("01")>=0){
            prev=s;
            
            s = s.replaceAll("01", "10");
            t++;
        }
        
        return t;
        
        
    }
}