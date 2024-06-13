// https://leetcode.com/problems/longest-palindrome

class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for(char ch : s.toCharArray()){
            arr[ch-'A']++;
        }
        
        
        int res = 0;
        boolean single = false;
        
        for(int i=0; i<128; i++){
            if(arr[i]>0){
                res+=arr[i]/2*2;
                arr[i]-=arr[i]/2*2;
            }
        }
        
        for(int i=0; i<128; i++){
        
            if(arr[i]>0){
                res+=1;
                break;
            }
                
        }
        
        return res;
        
    }
}