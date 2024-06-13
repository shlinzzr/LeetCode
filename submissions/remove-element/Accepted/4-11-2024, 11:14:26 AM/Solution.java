// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt= 0 ;

        int idx= 0 ;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                cnt++;
                
                nums[idx++] = nums[i];
                // idx++;
                // swap(nums, idx, i);
            }else{
                
                // idx++;
            }
        }
        
        return cnt;
        
    }
    
    private void swap(int[] nums, int a, int b){
        int t= nums[a];
        nums[a] = nums[b];
        nums[b]=t;
    }
}