// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        List<int[]> list = new ArrayList<>();
        int idx= 0 ;

        int len = intervals.length;

        while(idx<len && intervals[idx][1] < newInterval[0]){
            list.add(intervals[idx]);
            idx++;
        }

        while(idx<len && intervals[idx][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }

        list.add(newInterval);

        while(idx<len){
            list.add(intervals[idx++]);
        }

        int[][] res = new int[list.size()][];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }

        return res;
        
    }
}