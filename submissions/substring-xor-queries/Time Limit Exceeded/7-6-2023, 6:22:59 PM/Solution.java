// https://leetcode.com/problems/substring-xor-queries

class Solution {
    public int[][] substringXorQueries(String s, int[][] q) {
        int len = q.length;
        int[] ans = new int[len];
        for(int i=0; i<len; i++){
            ans[i] = q[i][0]^q[i][1];
        }
        
        int[][] res = new int[len][2];
        
        for(int i=0; i<len; i++){
            
            String str = Integer.toBinaryString(ans[i]);
            
            int idx = s.indexOf(str);
            
            if(idx==-1){
                res[i][0] = -1;
                res[i][1] = -1;
                continue;
            }
            
            // System.out.println( i + " " + str);
            res[i][0]=s.indexOf(str);
            res[i][1]=s.indexOf(str)+str.length()-1;
        }
        
        return res;
        
        
        
        
        
        
    }
}