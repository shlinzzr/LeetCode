// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range

class Solution {
    public int countOdds(int low, int high) {
        
        //唯一正解就是找出正反範例來跑
        
        
        if(low%2==1){
            
            if((high-low)%2==0)
                return (high-low)/2+1;
            else 
                return (high-low)/2+1;
        }else{
            
            if((high-low)%2==0)
                return (high-low)/2;
            else 
                return (high-low)/2+1;
            
            
        }
        
//           if((low-high)%2==0){
//             if(low%2==0){
//                 return (high-low)/2;
//             }else{
//                 return (high-low)/2+1;    
//             }
//         }
            
//         else{
//             return (high-low)/2+1;
//         }
        
        
        
    }
}