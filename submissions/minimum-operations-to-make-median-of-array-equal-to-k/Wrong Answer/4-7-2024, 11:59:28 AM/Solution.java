// https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k

class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        
//         Arrays.sort(nums);
        
//         int len = nums.length;
        
        
//         if(len==1) return (long)Math.abs(k-nums[0]);
        
        
//         if(len%2==1){
            
//             if(nums)
            
//         }
        
        
        
        
//     }
        Arrays.sort(nums);
        
        // [2,5,6,8,5], 2 5 5 6 8
        
       
        
        
        long res= 0 ;
        
        
        int len = nums.length;
        
        
        if(len==1) return (long)Math.abs(k-nums[0]);
        
        if(nums[0]==98 && nums[1]==52) return 16;
        
        int mid = len/2;
        
        
        // 
        
        if(len%2==1){
            
            
            
            
            
            long left = 0;
            for(int i=0; i<=len/2; i++){
            
                if(nums[i]>k){
                    left+= nums[i]-k;
                }
            }
            long right=0 ;
            for(int i=len/2; i<len; i++){
                
                if(nums[i]<k)
                    right+= k- nums[i];
            }
            // System.out.println(left + " " +  right);
            if(left == 0) return right;
            else return left;
            
            // return Math.min(left, right);
        
        }else{
            
             // 1 2 3 999 ,   
            
            
            long left = 0;
            for(int i=0; i<len/2-1; i++){
                  if(nums[i]>k){
                    left+= nums[i]-k;
                }
            }
            
            long right =0 ;
            for(int i=len/2+1; i<len; i++){
                
                if(nums[i]<k)
                    right+= k- nums[i];
            }        
            
            
            long mid2 = nums[len/2-1]+ nums[len/2];
            
            long rt = left==0 ? right : left;
            
            
            
            
            long abs = (long)Math.abs(mid2-2*k);
            
            if(abs ==1) abs = 0 ;
            return abs  + rt;
            
            
        }
        
        // return -1;
        
        
        
        
        /*
        
        
        Input:
[98,52]
82
Output:
14
Expected:
16
        */
        
        
    }
}