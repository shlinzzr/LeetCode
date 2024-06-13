// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int len = nums.length;

        int st =0 ;
        for(int ed=0; ed<len; ed++){

            while(ed+1<len && nums[ed+1]== nums[ed]+1){
                ed++;
            }

            if(st!=ed){
                res.add(nums[st] + "->"+ nums[ed]);

            }else{
                res.add( nums[st]+"");
            }

            st = ed+1;

        }

        return res;
        
    }
}