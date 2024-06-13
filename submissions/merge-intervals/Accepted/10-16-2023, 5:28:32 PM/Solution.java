// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        List<int[]> list = new ArrayList<>();


        int len = intervals.length;

        int i =0;
        while(i<len){
            int[] curr = intervals[i];
            i++;
            while(i<len && curr[1]>=intervals[i][0]){
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
                i++;
            }

            list.add(new int[]{curr[0], curr[1]});
        }

        int[][] res= new int[list.size()][];
        for(int j=0; j<list.size(); j++){
            res[j] = list.get(j);
        }

        return res;
    }

}