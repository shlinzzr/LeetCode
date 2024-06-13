// https://leetcode.com/problems/find-the-divisibility-array-of-a-string

class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        
        int len = word.length();
        
        int[] res = new int[len];
        long sum = 0;
        for(int i=0; i<len; i++){
            int digit = word.charAt(i)-'0';
            
            sum = sum*10 + digit;
            
            if(sum%m==0){
                res[i]=1;
                sum=0;
            }else{
                res[i]=0;
            }
            
            
        }
        
        return res;
    }
}