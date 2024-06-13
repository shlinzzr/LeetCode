// https://leetcode.com/problems/movement-of-robots

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
            
        for(int i=0; i<len; i++){

            char ch = s.charAt(i);

            if(ch=='R'){
                nums[i]+=d;

            }else{
                nums[i]-=d;
            }
        }
        
        int M = (int) 1e9+7;
            
        long res=0;
        
        Arrays.sort(nums);
        
        for(int i=0;i<len-1;i++){
            
            long dis = (long)nums[i+1] - (long)nums[i];
            res = res + dis%M * (i+1)%M * (len-i-1)%M ;
            res %=M;
            
        }
        
        
        
        
        
        
        return (int)res;
        
        
        
        
        
//         long res =0;
//         for(int i=0; i<len; i++){
//             for(int j=i+1; j<len; j++){
//                 res = res + Math.abs(nums[i]-nums[j])%M;
//                 res%=M;
//             }
//         }
        
        // return (int)res;
        
       
    }
}