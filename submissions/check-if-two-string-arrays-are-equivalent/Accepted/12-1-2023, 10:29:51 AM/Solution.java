// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int len1 = word1.length;
        int len2 = word2.length;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(String w : word1){
            sb1.append(w);
        }

        for(String w : word2){
            sb2.append(w);
        }

        return sb1.toString().equals(sb2.toString());
    }
}