// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[1]!=b[1]? a[1]-b[1] : a[0]-b[0]);
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        
        if(len==1)
            return intervals;
        
        int[] curr = intervals[0];
        int idx = 0;
        
        while(idx<len){
            
            boolean merge = false;
            while(idx<len && curr[1]>=intervals[idx][0]){
                // curr[0] = Math.min(curr[0], intervals[idx][0]);
                curr[1] = Math.max(curr[1], intervals[idx][1]);
                idx++;
                merge=true;
            }
            
            list.add(curr);
            
            if(!merge)
                idx++;
            
            if(idx<len)
                curr = intervals[idx];
        }
        
        int[][] res = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
    }
}