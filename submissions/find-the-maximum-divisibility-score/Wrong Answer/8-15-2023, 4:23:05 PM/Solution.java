// https://leetcode.com/problems/find-the-maximum-divisibility-score

class Solution {
    public int maxDivScore(int[] nums, int[] div) {
        int res = 0;
        
        int[] arr = new int[div.length];
        
        int max = 0;
        
        
        for(int j=0; j<div.length; j++){

            int cnt =0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]%div[j]==0)
                    cnt++;
            }
            
            arr[j] = cnt;
            
            if(cnt > max){
                max = cnt;
                res = j;
            }
            
        }
        
        return div[res];
    }
}