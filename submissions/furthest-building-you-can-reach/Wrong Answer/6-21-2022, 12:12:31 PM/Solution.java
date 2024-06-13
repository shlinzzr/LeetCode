// https://leetcode.com/problems/furthest-building-you-can-reach

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int[] maxGap = new int[ladders];  // int new[1]
            
            
        for(int i=0; i<heights.length; i++){
            
            if( i==heights.length-1 || heights[i] > heights[i+1]){
                continue;
            
            }else{
                int needBricks = heights[i+1] - heights[i]; //8, 5
                
                if(needBricks>maxGap[0]){  // maxGap = [5, 8]
                    handleMaxGap(maxGap, needBricks);
                }
                
                if(bricks > needBricks){
                    bricks -= needBricks;
                }else{
                     System.out.println("1st round: i="+i);
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
            
            if(ins==0)
                break;
            
        }
        
        
    }
    
 
}
//  class Solution {

//   public int furthestBuilding(int[] A, int bricks, int ladders) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int i = 0; i < A.length - 1; i++) {
//             int d = A[i + 1] - A[i];
//             if (d > 0)
//                 pq.add(d);
//             if (pq.size() > ladders)
//                 bricks -= pq.poll();
//             if (bricks < 0)
//                 return i;
//         }
//         return A.length - 1;
//     }
//  }