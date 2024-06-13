// https://leetcode.com/problems/count-of-interesting-subarrays

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

        long res = 0L;

        int[] arr = new int[nums.size()];
        int len = arr.length;
        for(int i=0; i<arr.length; i++){
            arr[i] = nums.get(i)%modulo==k ? 1 : 0;
        }

        Map<Long, Integer> map = new HashMap<>(); // sum, cnt
        map.put(0L, 1);

        long presum = 0 ;
        for(int i=0; i<len; i++){
            presum += arr[i];
            long mod = (presum + modulo)%modulo;
            if(map.containsKey(mod)){
                res+= map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0)+1);
        }

        return res;
    }
}