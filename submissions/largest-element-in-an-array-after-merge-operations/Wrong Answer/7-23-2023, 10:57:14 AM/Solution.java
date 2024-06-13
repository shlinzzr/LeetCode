// https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations

class Solution {
    public long maxArrayValue(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int len = nums.length;
        
        if(len==1)
            return nums[0];
        
        int curr = nums[len-1];
        int max = 0 ;
        for(int i=len-1; i>0; i--){
            
            if(curr>=nums[i-1]){
                curr += nums[i-1];
                max= Math.max(max, curr);
            }else{
                curr = nums[i-1];
            }
            
        }
        
        
        return max;
        
        
        
//         for(int n : nums){
//             list.add(n);
//         }
        
        
//         int prev = list.size();
//         boolean first = true;
        
//         while(true || list.size()!=prev){
            
//             prev  = list.size();
            
//             for(int i=list.size()-1; i>0; i--){
                
                
//                 if(list.get(i))
                
//             }
            
            
//         }
        
        
        
        
    }
}