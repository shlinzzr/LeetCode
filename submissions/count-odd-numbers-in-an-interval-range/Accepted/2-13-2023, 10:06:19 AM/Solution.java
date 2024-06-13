// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range

class Solution {
    public int countOdds(int low, int high) {
        int cnt = 0;
        
//         for(int i=low; i<=high; i++){
//             if(i%2==1)
//                 cnt++;
            
//         }
        
        if((low-high)%2==0){
            if(low%2==0){
                return (high-low)/2;
            }else{
                return (high-low)/2+1;    
            }
        }
            
        else{
            return (high-low)/2+1;
        }
        
    }
}