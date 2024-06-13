// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);

        int res = 0;

        int ed=0;
        for(int st=0; st<len; st++){
            while(map.lastKey()- map.firstKey()<=limit){
                res = Math.max(res, ed-st+1);
                ed++;

                if(ed<len)
                    map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
                else
                    break;
            }

            map.put(nums[st], map.get(nums[st])-1);
            if(map.get(nums[st])==0)
                map.remove(nums[st]);
        }

        return res;
    }
}

//[8,2,4,7]