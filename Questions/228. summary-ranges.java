// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        
        int len = nums.length;
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            while(ed<len-1 && nums[ed] +1 == nums[ed+1]){
                ed++;
            }
            
            if(st!=ed){
                list.add(nums[st]+"->"+nums[ed]);
            }else{
                list.add(nums[st]+"");
            }
            
            st=ed+1;
            
            
        }
        
        return list;
        
        
    }
}