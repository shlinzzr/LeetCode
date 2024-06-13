// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        
        int len = nums.length;
        int st=0, ed=0;
        for(int i=0; i<len; i++){
            
            while(i<len-1 && nums[i] +1 == nums[i+1]){
                ed++;
                i++;
            }
            
            if(st!=ed){
                list.add(nums[st]+"->"+nums[ed]);
            }else{
                list.add(nums[st]+"");
            }
            
            st=i+1;
            ed=i+1;
            
            
        }
        
        return list;
        
        
    }
}