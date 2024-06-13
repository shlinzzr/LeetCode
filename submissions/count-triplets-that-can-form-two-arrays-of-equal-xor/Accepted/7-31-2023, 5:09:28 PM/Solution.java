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
                
                // System.out.println(i +" " + j + " " + xor);
                
                if(xor==0){
                    res+= (j-i);
                    // System.out.println("hello  res="+res);
                }
                    
            }
        }
        
        return res;
        
        
    }
}