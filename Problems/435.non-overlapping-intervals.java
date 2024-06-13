// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] inter) {

        Arrays.sort(inter,(a,b)->a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);

        int len = inter.length;

        int[] prev = inter[0];

        int cnt = 0;
        for(int i=1; i<len; i++){
            int[] cur = inter[i];

            if(cur[0] < prev[1]){
                // prev[1] = Math.max(prev[1], cur[1]);
                // prev[0] = Math.max(cur[0] , prev[0]);
                cnt++;
            }else{
                prev = cur;
            }
        }

        return cnt;
        
    }
}