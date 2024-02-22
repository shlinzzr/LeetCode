// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for(int i=0; i<arr.length; i++){
            if(arr[i].startsWith(searchWord))
                return i+1;
        }
        return -1;
    }
}