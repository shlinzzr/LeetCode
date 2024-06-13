// https://leetcode.com/problems/longest-palindrome

class Solution {
    
    int max = 0;
    public int longestPalindrome(String s) {
        int len = s.length();
        
        if(len==1)
            return 1;

        char[] arr = new char[128];
        
        
        for(int i=0; i<len ; i++){ //a65A97
            arr[s.charAt(i)-'A']++;
        }
        
        boolean single = false;
        
        for(int a : arr){
            
            if(a%2==1)
                single = true;
            
            if(a>=2){
                max+=(a%2==0) ? a : a-1;
            }
            
        }
        
        
        
        
        
        return single ? max+1 : max;
        
    }
    
}