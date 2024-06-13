// https://leetcode.com/problems/find-the-distinct-difference-array

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        
        int[] res = new int[len];
        
        for(int i=0; i<len; i++){
            
            HashSet<Integer> prefix = new HashSet<>(); 
            HashSet<Integer> suffix = new HashSet<>();
            for(int j=0; j<len; j++){
                
                
                if(j<=i){
                    prefix.add(nums[j]);                 
                }else{
                    suffix.add(nums[j]);
                }
            }
            
            res[i] = prefix.size()-suffix.size();
            
        }
        return res;
    }
}