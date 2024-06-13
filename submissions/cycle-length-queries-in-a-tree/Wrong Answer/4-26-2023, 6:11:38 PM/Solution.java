// https://leetcode.com/problems/cycle-length-queries-in-a-tree

class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int len = queries.length;
        
        int[] res= new int[len];
        
        for(int i=0; i<len; i++){
            int[] q = queries[i];
            
            int lv1 = 0;
            while(q[0]>1){
                q[0]/=2;
                lv1++;
            }
            
            int lv2 = 0;
            while(q[1]>1){
                q[1]/=2;
                lv2++;
            }
            
            res[i] = lv1+lv2+1;
        }
        
        return res;
        
    }
}