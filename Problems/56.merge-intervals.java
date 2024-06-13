// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {

        int len = intervals.length;
        if(len==1) return intervals;

        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        int[] prev = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<len; i++){
            int[] curr = intervals[i];
            if(prev[1] < curr[0]){
                list.add(prev);
                prev= curr;
                continue;
            }

            prev[1] = Math.max(prev[1], curr[1]);
        }

        list.add(prev);

        int[][] res = new int[list.size()][];
        for(int i=0; i<res.length; i++){
            res[i]= list.get(i);
        }
        return res;

    }
}