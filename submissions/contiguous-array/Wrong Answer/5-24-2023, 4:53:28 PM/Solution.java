// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        
        int cnt=0;
        int max=0;
            
        int sum = 0;
        for(int n : nums){
            
            if(n==1)
                sum+=1;
            else
                sum-=1;
            
            if(sum > 1 || sum < -1){
                cnt=1;
                sum=(n==1)?1:-1;
                continue;
            }
            
            cnt++;
            
            if(sum==0){
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}