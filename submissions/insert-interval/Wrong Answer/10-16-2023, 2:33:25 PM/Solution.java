// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list =new ArrayList<>();
        Arrays.sort(intervals, (a,b)->(a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]));

        boolean ins = false;

        int len = intervals.length;
        for(int i=0; i<len; i++){
            int[] cur = intervals[i];

            if(cur[1]<newInterval[0]){
                list.add(cur);
                continue;
            }
            
            if(newInterval[0]<=cur[1] && cur[0]<=newInterval[1]){
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
                continue;
            }

            if(ins==false){
                list.add(newInterval);
                ins = true;
            }
                
            if(cur[0]>newInterval[1]){
                list.add(cur);
            }
                
        }

        int[][] res = new int[list.size()][];
        for(int i =0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
        


    }
}