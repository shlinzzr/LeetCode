// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        
        
        long st=0, ed=num;
        
        while(st<ed){
            
            long mid = st + (ed-st)/2;
            
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