// https://leetcode.com/problems/count-days-without-meetings

class Solution {
    public int countDays(int days, int[][] meetings) {
        
        Arrays.sort(meetings, (a,b)->a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        
        
        int len =meetings.length;
        
        if(len==1){
            days -= meetings[0][1]-meetings[0][0]+1;
            return days;
        }
        
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
        
        
        // 14
// [,
        
       // 1 3,  3 9, [3,13] 5 8, 5 10, 6 11, 8 9,  ,,[7,13],[8,13],[11,13]
          
      // 
    //.  
        
    }
}