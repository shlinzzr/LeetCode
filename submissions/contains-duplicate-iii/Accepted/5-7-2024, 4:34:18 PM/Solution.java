// https://leetcode.com/problems/contains-duplicate-iii

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        int len = nums.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int st= 0 ;
        for(int ed=0; ed<len; ed++){

            

            Integer lo = map.floorKey(nums[ed]+valueDiff);
            if(lo!=null && lo>=nums[ed]) return true;

            Integer hi = map.ceilingKey(nums[ed]-valueDiff);
            if(hi!=null && hi<=nums[ed]) return true;
            
            map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            
            if(ed-st<indexDiff ) continue;
            map.put(nums[st], map.get(nums[st])-1);
            if(map.get(nums[st])==0) map.remove(nums[st]);
            st++;

        }
        return false;
    }
}