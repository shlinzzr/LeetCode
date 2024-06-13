// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0)
                nums[i] = -1;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);// <sum, idx>
        
        int sum=0, max=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            
             if(map.containsKey(sum)){
                int preIdx = map.get(sum);
                max = Math.max(i-preIdx, max);
            }else{
                map.put(sum, i);
            }
            
        }
        
        return max;
    }
}