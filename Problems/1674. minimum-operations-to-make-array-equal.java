// https://leetcode.com/problems/minimum-operations-to-make-array-equal

class Solution {
    public int minOperations(int n) {
        
        int total =0;
        for(int i=0; i<n/2; i++){
            
            if(n%2==0){
                total+=2*i+1;
            }else{
                total+=2*i+2;
            }
            
        }
        
        return total;
        
    }
}