// https://leetcode.com/problems/continuous-subarrays

class Solution {
    public long continuousSubarrays(int[] nums) {
        int len = nums.length;

        TreeMap<Long, Long> map = new TreeMap<>();

        long res= 0 ;


        int st=0;
        for(int i=0; i<len; i++){
            map.put((long)nums[i], map.getOrDefault((long)nums[i],0L)+1);

            while(!map.isEmpty() && map.lastKey()-map.firstKey() >2){
                 map.put((long)nums[st], map.getOrDefault((long)nums[st],0L)-1);
                 if(map.get((long)nums[st])<=0)
                    map.remove((long)nums[st]);
                st++;
            }

            res+= (i-st+1);

        }

        return res;

    }
}