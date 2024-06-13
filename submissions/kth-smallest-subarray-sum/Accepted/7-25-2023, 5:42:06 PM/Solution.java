// https://leetcode.com/problems/kth-smallest-subarray-sum

class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int len = nums.length;
        
        
        int[] presum = new int[len+1];
        for(int i=0; i<len; i++){
            presum[i+1] = presum[i]+nums[i];
        }
        
        int st=0, ed = Integer.MAX_VALUE;
        
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            
            if(countLessEqual(nums, mid)<k){
                st = mid+1;
            }else{
                ed = mid;
            }
                
            
        }
        
        return st;
        
        
    }

    
    private int countLessEqual(int[] nums, int target) {
        int count = 0, sum = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    
//     private int getCnt(int[] presum, int mid){
//         int len = presum.length;
//         for()
//     }
}