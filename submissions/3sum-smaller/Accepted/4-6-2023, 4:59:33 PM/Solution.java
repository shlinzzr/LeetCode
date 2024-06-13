// https://leetcode.com/problems/3sum-smaller

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        int len = nums.length;
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int res =0;
        for(int i=0; i<len-2; i++){

            
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    
                    int sum = nums[i]+nums[j]+nums[k];                    
                    
                    if(sum>=target)
                        break;
                    
                    res++;
                }
            }
            
            
//             while(j<k){
                
//                 int sum = nums[i]+nums[j]+nums[k];
                
//                 if(sum < target){
//                     res++;
//                 }
                
//                 if(abs<min){
//                     res = sum;
//                     min = abs;
//                 }
                
//                 if(sum==target)
//                     return target;
                
//                 else if(sum<target)
//                     j++;
//                 else 
//                     k--;
//             }
        }
        
        return res;
    }
}
        
