// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        // // 1. sort
        // Arrays.sort(nums);
        // for(int i=0; i<nums.length-1; i++){
        //     if(nums[i]==nums[i+1])
        //         return nums[i];
        // }
        // return -1;
        
        // 2. set
        // Set<Integer> set = new HashSet<>();
        // for(int i : nums){
        //     if(set.contains(i))
        //         return i;
        //     set.add(i);
        // }
        // return -1;
        
        
        //3. Negatinve marking
        for(int i=0; i<nums.length; i++){
            int cur = Math.abs(nums[i]);
            
            if(nums[cur]>0){
                nums[cur] *= -1;
            }else{
                return Math.abs(nums[i]);
            }
        }
        
        return -1;
        
        
    }
}