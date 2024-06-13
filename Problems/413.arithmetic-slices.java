// https://leetcode.com/problems/arithmetic-slices

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        
        int cnt=0;
        for(int i=1; i<len-1; i++){
            
            int st=i, ed=i;
            while(st-1>=0 && ed+1<len && nums[st]-nums[st-1] == nums[ed+1]-nums[ed]){
                // System.out.println(st + " " + ed);
                cnt++;
                st--;
                ed++;
            }
            
            st=i;
            ed=i+1;
            int diff= nums[ed]-nums[st];
            
            while(st-1>=0 && ed+1<len && nums[st]-nums[st-1] == diff && diff== nums[ed+1]-nums[ed]){
                 // System.out.println(st + " " + ed);
                cnt++;
                st--;
                ed++;
            }
            
            
        }
        
        return cnt;
    }
}