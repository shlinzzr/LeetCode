// https://leetcode.com/problems/number-of-arithmetic-triplets

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int cnt=0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int st=0; st<nums.length; st++){
            set.add(nums[st]);
        }
        
        for(int st=0; st<nums.length-2; st++){
            int n = nums[st];
            if(set.contains(n+diff)&&set.contains(n+diff+diff)){
                cnt++;
            }
        }
        
        return cnt;
    }
}