// https://leetcode.com/problems/cycle-length-queries-in-a-tree

class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int len = queries.length;
        
        int[] res= new int[len];
        
        for(int i=0; i<len; i++){
            int[] q = queries[i];
            
            Set<Integer> set = new HashSet<>();
            int lv1 = 0;
            while(q[0]>1){
                q[0]/=2;
                lv1++;
                set.add(q[0]);
            }
            
            boolean con = false;
            
            int lv2 = 0;
            int lv3=0;
            while(q[1]>1){
                
                if(set.contains(q[1]))
                    con=true;
                if(con)
                    lv3++;
                
                q[1]/=2;
                lv2++;
            }
            
            res[i] = lv1+lv2-2*lv3+1;
        }
        
        return res;
        
    }
}