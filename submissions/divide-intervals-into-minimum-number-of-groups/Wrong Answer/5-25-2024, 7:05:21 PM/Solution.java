// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        List<int[]> list = new ArrayList<>();
        int idx= 0 ;
        int len = intervals.length;

        int g=1;

        int[] prev = intervals[0];
        for(int i=1; i<len; i++){

            int[] curr = intervals[i];
            if(prev[1] < curr[0]){
                list.add(prev);
                prev = curr;
                continue;
            }

            if(prev[1]<=curr[1]){
                prev[1] = Math.max(prev[1], curr[1]);
                g ++;
                continue; 
            }
        }

        list.add(prev);

        return g;
        
    }
}