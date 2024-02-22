// https://leetcode.com/problems/longest-palindrome

class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[52];
        
        for(char ch : s.toCharArray()){
            
            if(ch>='a' && ch<='z')
                arr[ch-'a']++;
            
            if(ch>='A' && ch<='Z')
                arr[ch-'A'+26]++;
        }
        
        int res = 0;
        boolean single = false;
        for(int i=0; i<52; i++){
            
            if(arr[i]%2==1){
                single=true;
                res += arr[i]-1;
            }
                
            else{
                res += arr[i];
            }
        }
        
        return single ? res+1 : res;
    }
}