// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays

class Solution {
    public int waysToSplit(int[] nums) {
        int len = nums.length, res = 0;
        
        // create presum
        for (int i = 1; i < len; ++i)
            nums[i] += nums[i - 1]; 
        
        for (int i = 0, j = 0, k = 0; i < len-2; ++i) {
            
            // find base j ==> presum[j]-presum[i] >= presum[i] ==> presum[j] >= 2*presum[i]
            while (j <= i || (j < len-1 && nums[j] < nums[i] * 2))
                ++j;
            
            //find base k, "k can equal to j, It's aviliable"
            while (k < j || ( k < len-1 && nums[k] - nums[i] <= nums[len-1] - nums[k]))
                ++k;
            
            res = (res + (k-1) - j +1 ) % 1000000007;
        }    
        return res;
    }
    
    
//     public int waysToSplit(int[] nums) {
//          int len = nums.length;
//         int res = 0;
        
//         int[] prefix = new int[len];
        
//         for(int i=0; i<len;i++){
//             prefix[i] = (i>0)? prefix[i-1] : 0  + nums[i];
//         }
        
//         for(int i=0; i<len; i++){
//             //find max j
//             int st = i+1; //1
//             int ed = len-2; // 1
            
//             while(st<ed){
                
//                 int mid = st+(ed-st)/2; //1
                
//                 if(isOk(prefix, i, mid, len-1)){
//                     st = mid;
                    
//                 }else{
//                     ed= mid-1;
//                 }
//             }
            
//             if(isOk(prefix, i, st, ed))
//                 res += st-i;
//         }
        
//         return res;
        
        
//     }
    
//     // 0 2 2
//     private boolean isOk(int[] prefix, int i, int j, int k){
//         return prefix[k]-prefix[j] >= prefix[j]-prefix[i];
//     }
    
    
    
    
//     XXX | X  X X X X X
//       i   st   ^   ed
}