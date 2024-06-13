// https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array

class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        
        for(int st=0; st<nums.size(); st++){
            boolean flag = true;
            for(int i=0; i<nums.size()-1;i++){
                int idx = (i-st+nums.size())%nums.size();
                int next = (i-st+1+nums.size())%nums.size();
                
                if(nums.get(idx)>nums.get(next)){
                    flag=false;
                    break;
                }
            }
            
            if(flag)
                return st;
            
        }
        
        return -1;
        
    }
}