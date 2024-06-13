// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        int len = intervals.length;
        int[] prev = intervals[0];

        List<int[]> list = new ArrayList<>();

        for(int i=1; i<len; i++){
            int[] cur = intervals[i];

            if(cur[0]>prev[1]){
                list.add(new int[]{prev[0], prev[1]});
                prev = cur;

            }else{
                prev[1] = Math.max(prev[1], cur[1]);             
            }

               if(i==len-1)
                    list.add(prev);
        }

        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;

    }
}