// https://leetcode.com/problems/furthest-building-you-can-reach

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int[] maxGap = new int[ladders];  // int new[1]
            
            
        for(int i=0; i<heights.length; i++){
            
            if( i==heights.length-1 || heights[i] > heights[i+1]){
                continue;
            
            }else{
                int needBricks = heights[i+1] - heights[i];
                
                if(needBricks>maxGap[0]){
                    handleMaxGap(maxGap, needBricks);
                }
                
                if(needBricks < bricks){
                    bricks -= needBricks;
                }else{
                    break;
                }
            }
        }
        
        
        for(int i=0; i<heights.length; i++){
            
           if(i==heights.length-1 || heights[i] > heights[i+1]){
                continue;
            
            }else{
                int needBricks = heights[i+1] - heights[i];
                
                if( checkUseLadders(maxGap, needBricks) ){
                    continue;
                    
                }else if(needBricks < bricks){
                    bricks -= needBricks;
                    
                }else{
                    return i;
                }
            }
        }
        
        return heights.length-1;
        
        
    }
    
    private boolean checkUseLadders(int[] maxGap, int ins){
        
        for(int i=maxGap.length-1; i>=0 ; i--){
            if(maxGap[i]==ins){
                maxGap[i] = -1;
                return true;
            } 
        }
        
        return false;
        
        
    }
    
    private void handleMaxGap(int[] maxGap, int ins){
        
        for(int i=maxGap.length-1; i>=0 ; i--){
            
            if(ins > maxGap[i]){
                int swp = maxGap[i];
                maxGap[i] = ins;
                ins = swp;
            }
            
        }
        
        
    }
    
 
}