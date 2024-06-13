// https://leetcode.com/problems/count-the-number-of-consistent-strings

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        char[] arr = allowed.toCharArray();
        int cnt=0;
        for(String w : words){
            
            boolean contain=true;
            for(char a : arr){
                w = w.replaceAll(""+a, "");
            }
            
            if(w.isEmpty())
                cnt++;
            
        }
        
        return cnt;
        
    }
}