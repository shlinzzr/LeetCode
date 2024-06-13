// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            
            
          for(int j=i+1;j<=i+k; j++){
            
            
             System.out.println("i="+i + " j="+j + " k="+k + " nums.length="+nums.length);
             if( j<nums.length && nums[i]==nums[j]){
            return true;
             }
          
          }
           
         
      }
        return false;
    }
}