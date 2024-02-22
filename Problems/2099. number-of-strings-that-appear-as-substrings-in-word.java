// https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        
        
        int cnt =0;
        for(String p : patterns){
            // char[] arr = p.toCharArray();
            if(word.contains(p))
                cnt++;
        }
        return cnt;
        
    }
}