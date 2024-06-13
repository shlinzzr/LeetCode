// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]==b[0]?a[1]-b[1] : a[0]-b[0]));
        
        List<int[]> list = new ArrayList<>();
        
        int len = intervals.length;
        
        int[] prev = null;
        for(int i=0; i<len-1; i++){
            
            if(intervals[i][1]<intervals[i+1][0]){
                list.add(intervals[i]);
            }else{
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            }
        }
        list.add(intervals[len-1]);
        
        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        
        return res;
        
    }
}