// https://leetcode.com/problems/longest-palindrome

class Solution {
    public int longestPalindrome(String s) {

        int[] arr = new int[52];
        for(char ch : s.toCharArray()){
            if(ch>='a' && ch<='z'){
                arr[ch-'a']++;

            }else if(ch>='A' && ch<='Z'){
                arr[ch-'A'+26]++;
            }
        }

        int res = 0 ;
        boolean single=false;

        for(int i=0; i<52;i++){
            res+= arr[i]/2*2;
            if(arr[i]%2==1) single=true;
        }

        if(single) res++;

        return res;
            
        
    }
}