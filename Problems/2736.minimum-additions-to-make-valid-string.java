// https://leetcode.com/problems/minimum-additions-to-make-valid-string

class Solution {
    
    public int addMinimum(String word) {
        
        int k = 0, prev = 'z', n = word.length();
        for (int i = 0; i < n; ++i) {
            
            if(word.charAt(i)<=prev)
                k++;  // start a new "abc",
            
            prev = word.charAt(i);
        }
        return k * 3 - n;  // insertion
    }
}

