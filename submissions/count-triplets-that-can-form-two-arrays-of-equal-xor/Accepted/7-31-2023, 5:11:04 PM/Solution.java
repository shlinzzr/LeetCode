// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {
        
// XXX   [ X X X X X X ][X X X X]  XXX
      // a=i^  ...^ j-1, j ... k
        
        
        // find arr where xor ==0;
        
        int len = arr.length;
        
        int res = 0;
        
        for(int i=0; i<len; i++){
            
            int xor = arr[i];
            
            for(int j=i+1; j<len; j++){
                
                xor ^= arr[j];
                if(xor==0){
                    res+= (j-i);// 總共有(j-i+1)個element, 切成多份且每份不為0個element有幾種切法？ => (j-i)種
                }
            }
        }
        
        return res;
        
        
    }
}