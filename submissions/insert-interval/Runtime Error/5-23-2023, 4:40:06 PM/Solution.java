// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>();
        
        int len = intervals.length;
        if(len==0)
            return new int[][]{{newInterval[0], newInterval[1]}};
        
        int idx =0;
        while(intervals[idx][1]<newInterval[0]){
            list.add(intervals[idx]);
            idx++;
        }
        
        
        while(idx<len && intervals[idx][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        
        list.add(newInterval);
        
     
        
        while(idx<len){
            list.add(intervals[idx]);
            idx++;
        }
        
        int[][] res = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
        
        
    }
}