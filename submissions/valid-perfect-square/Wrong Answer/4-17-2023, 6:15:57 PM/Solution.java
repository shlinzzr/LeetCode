// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        
        
        int st=0, ed=2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2;
        
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            
            long lg = mid*mid;
            
            if(lg==num)
                return true;
            else if(lg>num){
                ed=mid-1;
            }else{
                st = mid+1;
            }
                
            
            
        }
        
        return false;
        
    }
}