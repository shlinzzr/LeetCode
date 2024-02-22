// https://leetcode.com/problems/check-if-the-sentence-is-pangram

class Solution {
    public boolean checkIfPangram(String sentence) {
        int arr[] = new int[26];
        for(char c : sentence.toCharArray()){
            arr[c-'a']++;
        }
        
        for(int a: arr){
            if(a==0)
                return false;
        }
        
        return true;
        
    }
}