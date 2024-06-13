// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // int[][] res = new 
        
        List<int[]> list = new ArrayList<>();
        
        int i=0;
        for(i=0; i<intervals.length; i++){
            int[] val = intervals[i];
            if(val[1]<newInterval[0]){
                list.add(val);
                continue;
            }else
                break;
        }
        
        for(; i<intervals.length; i++){
            int[] val = intervals[i];
            
            if(val[0]<newInterval[1]){
                newInterval[0]= Math.min(val[0], newInterval[0]);
                newInterval[1]= Math.max(val[1], newInterval[1]);
            }else 
                break;
        }
        list.add(newInterval);
        
        
        for(; i<intervals.length; i++){
            int[] val = intervals[i];
            list.add(val);
        }
        
        int[][] res = new int[list.size()][2];
        for(i=0; i<list.size(); i++){
            res[i]=list.get(i);
        }
        
        return res;
        
    }
}