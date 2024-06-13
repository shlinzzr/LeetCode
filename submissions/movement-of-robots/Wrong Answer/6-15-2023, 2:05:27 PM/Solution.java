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
        
        
        
        
        
//         -3, -1, 1
        
//           ans = 0, pre=-3
//           ans = 1*-1-(-3)-(0)  = 2, pre = -4
//           ans = 2+2*1-(-4) = 8, pre=-3
              
//               return 
              
             
            
        long res=0;
        
        Arrays.sort(nums);

        
        
        for(int i=0;i<len-1;i++){
            
            int dis = nums[i+1] - nums[i];
            res = res + ((i+1)*dis*(len-i-1))%M;
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