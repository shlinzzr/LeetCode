// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int len = intervals.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        int[] curr = intervals[0];

        for(int i=0; i<len; i++){
            int[] p = intervals[i];
            int st = p[0];
            int ed = p[1];

            // int stKey = map.floorKey(st);

            map.put(st, map.floorEntry(st).getValue()+1);
            map.put(ed, map.floorEntry(ed).getValue()-1);
        }

        int cnt = 0 ;
        for(int k : map.keySet()){
            int val = map.get(k);
            cnt = Math.max(cnt, val);
        }

        return cnt-1;

        
    }
}