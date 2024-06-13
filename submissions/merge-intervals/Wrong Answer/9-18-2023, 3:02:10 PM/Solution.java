// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        List<int[]> list = new ArrayList<>();
        
        
        for(int i=0; i<intervals.length; i++){
            
            int[] prev = intervals[i];
            i++;
            
            while(i<intervals.length && intervals[i][0] < prev[1]){
                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
                i++;
            }
            
            list.add(new int[]{prev[0], prev[1]});            
            i--;
            
        }
        
        int[][] res = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        
        return res;
        
        
    }
}