// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list =new ArrayList<>();
        
        int len = intervals.length;
        int i=0;
        
        while(i<len && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        
        while(i<len && intervals[i][0]<=newInterval[1]){
            newInterval[0]= Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        
        while(i<len){
            list.add(intervals[i]);
            i++;
            
        }
        
        int[][] res = new int[list.size()][];
        for(int j=0; j<list.size(); j++){
            res[j] = list.get(j);
        }
        
        return res;
        
        
      
        
        
    }
}
