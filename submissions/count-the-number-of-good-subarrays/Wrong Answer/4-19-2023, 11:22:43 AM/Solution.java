// https://leetcode.com/problems/count-the-number-of-good-subarrays

class Solution {
    public long countGood(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int cnt =0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for(int key : map.keySet()){
            
            int val = map.get(key);
            int n = val*(val-1)/2;
            
            if((val)*(val-1)/2>=k)
                cnt++;
        }
        
        return cnt;
            
            
            
        
        
    }
}