// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        Arrays.sort(intervals, (a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        int len = intervals.length;
        
        
        
        
        List<int[]> list = new ArrayList<>();
        
        
        for(int i=0; i<len; i++){

            int[] curr = intervals[i];
            
            int j=i+1;
            
            while(j<len && intervals[j][0]<=curr[1]){
                curr[0] = Math.min(curr[0], intervals[j][0]);
                curr[1] = Math.max(curr[1], intervals[j][1]);
                j++;
            }
            
            list.add(curr);
            
            i=j-1;
            
        }
        
        int[][] res = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            res[i]=list.get(i);
        }
        
        return res;
        
        
    }
}