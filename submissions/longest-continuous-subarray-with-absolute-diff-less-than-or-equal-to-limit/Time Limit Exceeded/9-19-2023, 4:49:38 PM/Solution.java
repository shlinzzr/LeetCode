// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;


        int res = 0;

        int ed=0;
        for(int st=0; st<len; st++){


//  System.out.println("st="+st);
            ed=st;
            int max = nums[ed];
            int min = nums[ed];
            while(ed<len && max-min<=limit){
                ed++;
                if(ed>=len){
                    break;
                }

                max = Math.max(max, nums[ed]);
                min = Math.min(min, nums[ed]);
            }
            res = Math.max(res, ed-st);
            // System.out.println("res="+res + " " + st + " "+ ed);
        }

        return res;
    }
}

//[8,2,4,7]