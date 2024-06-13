// https://leetcode.com/problems/movement-of-robots

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        
        List<Long> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){

            char ch = s.charAt(i);

            if(ch=='R'){
                list.add(nums[i]+(long)d);

            }else{
                list.add(nums[i]-(long)d);
            }
        }
        
        int M = (int) 1e9+7;
            
        long ret=0;
        
        Collections.sort(list);
        
        for(int i=0;i<len-1;i++){
            
            // long dis = (nums[i+1] - nums[i])%M;
            // res = res%M + (dis%M * (i+1)%M * (len-i-1)%M)%M ;
            // res %=M;
            
            
            
            long dis = (list.get(i+1)-list.get(i)) % M;
            ret += dis * (i+1) % M * (len-1-i) % M;
            ret %= M;
            
        }
        
        
        
        
        
        
        return (int)ret;
        
        
        
        
        
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