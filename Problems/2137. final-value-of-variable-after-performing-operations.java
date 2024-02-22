// https://leetcode.com/problems/final-value-of-variable-after-performing-operations

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        
        int res =0;
        for(String str : operations){
            
            switch(str){
                    
                case "--X":

                case "X--":
                    res -=1;
                    break;    
                
                case "++X":
                case "X++":
                    res +=1;
                    break;
            }
        }
        
        return res;
        
    }
}