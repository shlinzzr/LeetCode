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

        boolean single = false;
        int res = 0;
        for(int a : arr){
            if(a>0){

                res += a/2*2;

                if(a%2!=0 && single==false){
                    single=true;
                    res+=1;
                }
            }
        }

        return res;
    }
}