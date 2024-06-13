// https://leetcode.com/problems/check-if-the-sentence-is-pangram

class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        
        for(int i=0; i<sentence.length(); i++){
            arr[sentence.charAt(i)-'a']++;
        }
        
        for(int a=0; a<arr.length; a++){
            if(arr[a]==0)
                return false;
        }
        return true;
        
    }
}