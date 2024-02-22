// https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int [queries.length];
        
        for(int q=0; q<queries.length; q++){
            
            int cnt = 0;
            int qx=queries[q][0];
            int qy=queries[q][1];
            int qr=queries[q][2];
            
            for(int p=0; p<points.length;p++){
                
                int px = points[p][0]; 
                int py = points[p][1];
                
                if( (qx-px)*(qx-px) + (qy-py)*(qy-py)  <= qr*qr)
                    cnt++;
                
            }
            
            res[q] = cnt;
            
            
        }
        return res;
        
    }
}