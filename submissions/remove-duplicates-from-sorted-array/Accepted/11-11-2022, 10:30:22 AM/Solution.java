// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        
        int idx =0;
        
        for(int i=0; i<nums.length;i++){
            if(set.contains(nums[i])){
                // nums[i]=
            }else{
                set.add(nums[i]);    
                nums[idx] = nums[i];
                idx++;
            }
        }
        
        
        
        return set.size();
        
        
        
    }
}