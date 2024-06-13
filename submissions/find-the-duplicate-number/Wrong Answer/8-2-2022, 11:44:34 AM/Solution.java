// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        // 1. sort
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(nums[i]==nums[i+1])
                return nums[i];
        }
        return -1;
        
        
//         Set<Integer> set = new HashSet<>();
        
//         for(int i : nums){
//             if(set.contains(i))
//                 return i;
            
//             set.add(i);
            
//         }
        
//         return -1;
        
    }
}