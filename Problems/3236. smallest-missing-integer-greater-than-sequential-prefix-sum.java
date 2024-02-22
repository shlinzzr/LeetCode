// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum

class Solution {
    public int missingInteger(int[] nums) {
        int len = nums.length;
        
        
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int res = Integer.MAX_VALUE;
//         
        int longest = 0;
        int prefix = nums[0];
        for(int i=0; i<len; i++){
            
           
            int j = i;
            
              Set<Integer> a = new HashSet<>();
            int cur = nums[j];
             a.add(nums[j]);
          
            while(j+1<len && nums[j+1]==nums[j]+1){
               a.add(nums[j+1]);
                cur += nums[j+1];
                 j++;
            }
            
            if(a.contains(nums[0]) && j-i+1>longest){
                longest = j-i+1;
                prefix = cur;
                res = Math.min(res, prefix);
            }
            
        }
        // System.out.println(longest+ " " + prefix);
        
        while(set.contains(res)){
            res ++;
        }
        
        return res;
        
    }
    
    /*
    [1,2,3,2,5]
[3,4,5,1,12,14,13]
[37,1,2,9,5,8,5,2,9,4]
[14,9,6,9,7,9,10,4,9,9,4,4]
    */
}