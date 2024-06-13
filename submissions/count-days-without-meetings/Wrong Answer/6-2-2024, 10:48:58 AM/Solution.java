// https://leetcode.com/problems/count-days-without-meetings

class Solution {
    public int countDays(int days, int[][] meetings) {
        
        Arrays.sort(meetings, (a,b)->a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);
        
        int len =meetings.length;
        int[] prev = meetings[0];
        
        int cnt = 0;
        
        for(int i=1; i<len; i++){
            int[] curr = meetings[i];
            
            if(prev[1]<curr[0]){
                
                cnt += prev[1]-prev[0]+1;
                prev = curr;
                
            }else{
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
            
            // 1 3, 2 4
        }
        // 3 4, 2 5, 3 8, 4 8
        // 3 8 
        cnt += prev[1]-prev[0]+1;
        
        return days-cnt;
        
    }
}