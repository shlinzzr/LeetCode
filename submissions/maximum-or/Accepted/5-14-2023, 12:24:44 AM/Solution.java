// https://leetcode.com/problems/maximum-or

class Solution {
    
   // 12=101000
   //    9=1001  
    
 //    32 16 8 4 2 1
//     12 =   1 1 0 0
//      9 =   1 0 0 1
        
        
//    res =     1 1 0 1  k
        
//         res (~OR 12) OR 12*2  <> (~OR 9) OR 9*2
        
//      [9, 12]  => [4, 6]   res +=1 
//                  [2, 3]   
//                  [1, 1]   1
//                  [0, 0]   
        
//            // 1 1 1 1 0 = 30
    
        
//          11001 = 25
//          11110 = 30
    
    
        
    public long maximumOr(int[] nums, int k) {
        
        int len = nums.length;
        
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        
        int cur =0; 
        for(int i=0; i<len; i++){
             cur |= nums[i];
            prefix[i] = cur;
           
        }
        
        cur =0; 
        for(int i=len-1; i>=0; i--){
             cur |= nums[i];
            suffix[i] = cur;
           
        }
        
        long p = 1<<k;
        
//         long max = 0;
//         for(int i=0; i<len ;i++){
            
//             int n = nums[i];
            
//             max = Math.max(max , prefix[i]*n*p*suffix[i]);
//         }
        
        
//         return max;
        
           long maxOr = 0;
        for (int i = 0; i < len; i++) {
            long or = ((long) nums[i]) * (1L << k) | (i > 0 ? prefix[i-1] : 0) | (i < len-1 ? suffix[i+1] : 0);
            maxOr = Math.max(maxOr, or);
        }
        
        return maxOr;
        
        
        
        
//         int maxLen =0;
//         HashSet<String> set = new HashSet<>();
//         for(int n : nums){
//             String bin = Integer.toBinaryString(n);
//             if(bin.length()==maxLen)
//                 set.add(bin);
//             else if(bin.length()>maxLen){
//                 set = new HashSet<>();
//                 set.add(bin);
//                 maxLen = bin.length();
//             }
//         }
        
//         int max = 0;
//         for(String s : set){
//             max = Math.max(max, Integer.parseInt(s+"0",2));
//         }
        
// //         int max = 0;
// //         int idx = 0;
// //         int mul = Math.pow(2, k);
// //         for(int i=0; i<len; i++){
            
// //         }
        
//         System.out.println(max);
        
        
//         long res = 0;
//         for(int i=0; i<len&&k>0 ; i++){
            
//             while(k>0 && nums[i]==max){
//                 nums[i]*=2;
//                 k--;
//             }
            
//             res |= nums[i] ;
//         }
        
        
//         for(int i=len-1; i>=0 && k>0; i--){
            
//             long tmp = res;
            
//             int n = nums[i];
            
//             if()
            
            
//             nums[len-1] *=2;
//             k--;
//         }
        
        
        
        // return res;
        
    }
}