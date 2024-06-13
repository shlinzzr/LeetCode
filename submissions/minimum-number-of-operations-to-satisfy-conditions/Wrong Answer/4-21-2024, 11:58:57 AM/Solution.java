// https://leetcode.com/problems/minimum-number-of-operations-to-satisfy-conditions

class Solution {
    public int minimumOperations(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
         
        int[] cost = new int[w];
        int[][] color = new int[w][2];
        
        Map<Integer , Integer>[] map = new HashMap[w]; 
        
        
        for(int j=0; j<w; j++){
            map[j] = new HashMap<>();
            
            
            int top1 = 0;
            int top2 = 0;
            
            
            for(int i=0; i<h; i++){
                
                int c = grid[i][j];
                
                map[j].put(c, map[j].getOrDefault(c, 0)+1);
                
                if(map[j].get(c)>top1){
                    top2 = top1;
                    top1 = c;
                    
                }else if(map[j].get(c)>top2){
                    top2 = c;
                }
            }
            
            color[j] = new int[]{top1, top2};
        }
        
        
        int res=0;
        
        
        for(int j=w-2; j>=0; j--){
            
            if(color[j][0] == color[j+1][0]){
                
                if(j>0){
                    
                    
                    boolean check_prev = color[j-1][0]==color[j][0];
                    
                    // chage me

                    int cur1 =  h-map[j].get(color[j][1]);
                    int next1 = h-map[j+1].get(color[j+1][0]);
                    int prev1 = h-map[j-1].get(color[j-1][0]);
                    int sum1 = prev1 + cur1 + next1;

                    // change nexxt
                    int cur2 = h-map[j].get(color[j][0]);
                    int next2 =h-map[j+1].get(color[j+1][1]);
                    
                    
                    int prev2 = h-map[j-1].get(color[j-1][ check_prev ? 1 : 0]);
                    int sum2 = prev2 = cur2 + next2;
                    
                    
                    
                    if(sum1<sum2){
                        res += next1;
                        
                        if(j==w-2)
                            res+= next1;
                        
                    }else{
                        res += next2;
                        
                        if(j==w-2)
                            res += next2;
                    }
                    
                    
                }else{
                    
                    int cur1 =  h-map[j].get(color[j][1]);
                    int next1 = h-map[j+1].get(color[j+1][0]);
                    int sum1 = cur1 + next1;
                    
                     int cur2 = h-map[j].get(color[j][0]);
                    int next2 =h-map[j+1].get(color[j+1][1]);
                    
                    int sum2 =  cur2 + next2;
                    
                      if(sum1<sum2){
                        res += next1;
                      }else{
                        res += next2;
                      }
                    
                }
                
                
            }else{
                
                if(j==w-2)
                    res+= color[j+1][0];
                res += color[j][0];
            }
            
        }
        
        
        return res;
        
        
        
        
        
        
        
        
        
    }
}