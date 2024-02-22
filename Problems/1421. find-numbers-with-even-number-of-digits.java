// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {
        int cnt=0;
        for(int n: nums){
            String s = String.valueOf(n);
            if(s.length()%2==0)
                cnt++;
        }
        
        return cnt;
    }
}