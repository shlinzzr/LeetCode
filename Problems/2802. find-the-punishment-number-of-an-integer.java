// https://leetcode.com/problems/find-the-punishment-number-of-an-integer

class Solution {
    public int punishmentNumber(int n) {
        
        int sum=0;
        for(int i=1; i<=n; i++){
            
            int sq = i*i;
            
            if(helper(String.valueOf(sq), i))
                sum += sq;
        }
        
        return sum;
    }
    
    private boolean helper(String sq, int target){
        
        if(sq.isEmpty() && target==0)
            return true;
        if(target<0)
            return false;
        
        
        for(int i=0; i<sq.length(); i++){
            String left = sq.substring(0, i+1);
            String right = sq.substring(i+1);
            int leftNum = Integer.valueOf(left);
            
            boolean rt =  helper(right, target-leftNum);
            if(rt){
                return true;
            }
        }
        
        return false;
        
     
        
        
        
    }
}