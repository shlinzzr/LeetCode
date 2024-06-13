// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    //    for(int i=0;i<nums.length;i++){
    //       for(int j=i+1;j<=i+k; j++){            
    //          if( j<nums.length && nums[i]==nums[j]){
    //              return true;
    //          }
    //       }
    //    }
    //     return false;
        
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
        
    }
}