// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = nums.length;
        // int[] presum = new int[len+1];
        // for(int i=0; i<len; i++){
        //     presum[i+1] = nums[i]+presum[i];
        // }
        int sum = 0;

        for(int i=0; i<len; i++){
            sum += nums[i];
            sum%=k;

            if(map.containsKey(sum)){
                if(i-map.get(sum)>0){
                    return true;
                }
            }else{
                map.put(sum, i);
            }
        }

        return false;
        


        

        
    }
}