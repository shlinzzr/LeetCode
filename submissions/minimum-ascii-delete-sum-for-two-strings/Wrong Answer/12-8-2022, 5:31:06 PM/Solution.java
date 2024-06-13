// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[] arr = new int[26];
        for(char ch : s1.toCharArray()){
            arr[ch-'a']++;
        }
        
        for(char ch : s2.toCharArray()){
            arr[ch-'a']--;
        }
        
        
        int sum = 0;
        for(int i=0; i<26; i++){
            
            if(arr[i]!=0){
                sum+= (i+'a')*Math.abs(arr[i]);    
            }
        }
        
        return sum;
        
    }
}