// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum

class Solution {
    public int missingInteger(int[] nums) {
        int len = nums.length;
        
        
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        // int res = Integer.MAX_VALUE;
//         
        int longest = 1;
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
            }
            
        }
        // System.out.println(longest+ " " + prefix);
        
        while(set.contains(prefix)){
            prefix ++;
        }
        
        return prefix;
        
    }
}