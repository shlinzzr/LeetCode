// https://leetcode.com/problems/paint-house-ii

class Solution {
    public int minCostII(int[][] costs) {
        
        int h= costs.length;
        int w = costs[0].length;
        
        int[] dp = new int[w+1];
        
        int min1=-1;
        int min2=-1;
        
        
        for(int i=0; i<h; i++){
            
            int last1=min1;
            int last2=min2;
            
            min1 = -1;
            min2 = -1;
            
            for(int j=0;j<w; j++){
                
                if(j!=last1){
                    costs[i][j] += (last1<0? 0 : costs[i-1][last1]);
                }else{
                    costs[i][j] += (last2<0? 0 : costs[i-1][last2]);
                }
                
                if(min1<0 || costs[i][j]<costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                }else if(min2<0 || costs[i][j]<costs[i][min2]){
                    min2=j;
                }
            }
        }        
        return costs[h-1][min1];
        
    }
}