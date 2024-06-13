// https://leetcode.com/problems/count-pairs-in-two-arrays

class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        TreeMap<Long, Long> map = new TreeMap<>(); //val, cnt

        int len = nums1.length;
        long res = 0L;
        for(int i=0; i<len; i++){

            long val = nums1[i]-nums2[i];
            long need = (long) -val;

            Long floor = map.higherKey(need);
            while(floor!=null){

                res+= map.get(floor);

                floor = map.higherKey(floor);
            }

            map.put(val, map.getOrDefault(val,0L)+1);

        }

        return res;
        
    }
}