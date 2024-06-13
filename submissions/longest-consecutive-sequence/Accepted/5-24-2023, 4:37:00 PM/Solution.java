// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length<2)
            return nums.length;
        
        
        Arrays.sort(nums);
        
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);
        }
        

        int max = 0;
        
        for(int n :  nums){
            
            if(!set.contains(n-1)){
                
                int curr = n;
                int cnt=0;
                while(set.contains(curr)){
                    curr++;
                    cnt++;
                }
                
                max = Math.max(max, cnt);
            }
        }
        
        return max;
    }
}