// https://leetcode.com/problems/reordered-power-of-2

class Solution {
    
    
    
    public boolean reorderedPowerOf2(int n) {
        int[] inputFreq = freqCount(n);
        
        for(int i=0; i<31; i++){
            int powerOf2 = (int)Math.pow(2, i);
            int[] power2Freq = freqCount(powerOf2);
            
            if(compareArr(inputFreq, power2Freq)){
                return true;
            }
        }
        
        return false;
        
        
    }
    
    private boolean compareArr(int[] arr1, int[] arr2){
        for(int i=0; i<10; i++){
            if(arr1[i]!= arr2[i])
                return false;
        }
        return true;
    }
    
    
    
    private int[] freqCount(int n){
        int[] freq = new int[10];
        while(n>0){
            freq[n%10]++;
            n/=10;
        }
        return freq;
    }
    
    
//     private boolean isPowerOf2(int n){
        
//         if(n==1)
//             return true;
        
//         while(n>1){
            
//             if(n%2==1)
//                 return false;
            
//             n /=2;
//         }
        
//         return true;
        
//     }
}