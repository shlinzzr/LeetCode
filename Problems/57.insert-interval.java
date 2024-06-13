// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>();
        int len = intervals.length;
        
        int idx =0;
        
        while(idx<len && intervals[idx][1]<newInterval[0]){
            list.add(intervals[idx]);
            idx++;
        }
        
        while(idx<len && newInterval[1]>=intervals[idx][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        list.add(newInterval);
        
        while(idx<len){
            list.add(intervals[idx++]);
        }
        
        int[][] res = new int[list.size()][2];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        
        return res;
        
        
        
    }
}