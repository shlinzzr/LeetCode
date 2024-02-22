// https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent

class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr = new int[26];
        for(char ch : word1.toCharArray()){
            arr[ch-'a']++;
        }

        for(char ch : word2.toCharArray()){
            arr[ch-'a']--;
        }

        int cnt=0;
        for(int a : arr){
            if(a!=0){
                if(Math.abs(a)>3)
            
                    return false;
            }
        }

        return true;



    }
}