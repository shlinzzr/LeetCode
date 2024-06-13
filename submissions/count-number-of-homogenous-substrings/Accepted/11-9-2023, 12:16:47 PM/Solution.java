// https://leetcode.com/problems/count-number-of-homogenous-substrings

class Solution {
    public int countHomogenous(String s) {
        int M = (int)1e9+7;
        long res = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            res++;
            int cnt=1;
            while(i+1<s.length() && s.charAt(i+1)==ch){
                cnt++;
                res+=cnt;
                res%=M;
                i++;
            }
        }

        return (int)res;





        // long[] arr = new long[26];
        // for(char ch : s.toCharArray()){
        //     arr[ch-'a']++;
        // }

        // long sum = 0;
        // for(long a : arr){
        //     sum = (sum+a)%M;
        // }

        // return (int )sum;
    }
}