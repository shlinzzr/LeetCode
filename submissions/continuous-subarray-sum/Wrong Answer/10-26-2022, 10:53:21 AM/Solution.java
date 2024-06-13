// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // (mod, idx);
        
        for(int i=0; i<nums.length;i++){
            int n = nums[i]%k;
            if(map.containsKey(n) && i-map.get(n)>2){
                return true;
            }
            
            map.put(n , i);
        }
        
        return false;
        
    }
}