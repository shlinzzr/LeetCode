// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {
        
        int cnt=0;
        
        for(int n : nums){
            int d=0;
            while(n>0){
                n/=10;
                d++;
            }
            
            if(d%2==0) cnt++;
        }
        return cnt;
        
    }
}