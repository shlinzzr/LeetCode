// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences

class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int max = 0;
        for(String str : sentences){
            
            String[] wordArr = str.split(" ");
            if(wordArr.length>max)
                max = wordArr.length;
            
        }
        
        return max;
        
    }
}