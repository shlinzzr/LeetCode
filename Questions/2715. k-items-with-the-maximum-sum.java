// https://leetcode.com/problems/k-items-with-the-maximum-sum

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int sum =0;
        
         while(k>0){
             
             if(numOnes>0){
                 numOnes--;
                 sum+=1;
             }else if(numZeros>0){
                 numZeros--;
             }else{
                 numNegOnes--;
                 sum--;
             }
             
             k--;
         }
        
        return sum;
            
            
    }
}