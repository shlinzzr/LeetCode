// https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree

class Solution {
    public int minIncrements(int n, int[] cost) {
        
        int lv = 0;
        int t = n;
        while(t!=0){
            lv++;
            t/=2;
        }
        
        
        
        int cnt = 0;
       while(lv>0){
           
           int max = 0;
           
          
           int st = (int) Math.pow(2, lv-1)-1;
           int ed = (int) Math.pow(2, lv)-1;
           
            // System.out.println(lv + " "+ st + " " + ed);
           
           for(int i=st; i<ed; i++){
               max =Math.max(max , cost[i]);
           }
           
           for(int i=st; i<ed; i++){
               cnt += max - cost[i];
           }
           
           
           lv--;
           
       }
        
        return cnt;
        
        
    }
}