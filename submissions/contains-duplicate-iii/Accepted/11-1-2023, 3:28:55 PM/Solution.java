// https://leetcode.com/problems/contains-duplicate-iii

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int len = nums.length;

        TreeMap<Integer, Integer> map =new TreeMap<>(); // val, cnt
        int st= 0;
        for(int ed=0; ed<len; ed++){

            Integer floor = map.floorKey(nums[ed]+valueDiff);
            Integer ceiling = map.ceilingKey(nums[ed]-valueDiff);
            
            if( (floor!=null && floor>=nums[ed] )|| (ceiling!=null && ceiling<=nums[ed]))
                return true;
            

            map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);

            if(ed-st<indexDiff)
                continue;
            
            // for(int k : map.keySet()){
 
            // }

            map.put(nums[st], map.getOrDefault(nums[st],0)-1);
            if(map.get(nums[st])==0){
                map.remove(nums[st]);
            }
            st++;
        }

        return false;
    }
}