// https://leetcode.com/problems/count-complete-subarrays-in-an-array

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
        int len = nums.length;
        
        
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
      
        
        int res = 0;
        for(int i=0; i<len; i++){
            Set<Integer> set2 = new HashSet<>();
            for(int j=i; j<len; j++){
                set2.add(nums[j]);
                if(set2.size()==set.size()){
                    res+=1;
                }
            }
        }
        
        return res;
        
    }
}