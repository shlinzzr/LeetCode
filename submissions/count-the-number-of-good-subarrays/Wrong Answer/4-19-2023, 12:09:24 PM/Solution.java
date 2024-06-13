// https://leetcode.com/problems/count-the-number-of-good-subarrays

class Solution {
    public long countGood(int[] nums, int k) {
        // Arrays.sort(nums);
        int len = nums.length;
        int res =0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int pairs = 0;
        int ed=0;
        for(int st=0; st<len ; st++){
            
            while(ed<len && pairs<k){
                pairs += diff(map, nums[ed], 1);
                map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
                ed++;
            }
            
            if(pairs>=k){
                res += len-ed+1;
            }
            
            
            pairs += diff(map, nums[st], -1);
            map.put(nums[st], map.getOrDefault(nums[st], 0)-1);
        }
        return res;        
        
    }
    
    private int diff(HashMap<Integer, Integer> map , int num, int d){
        
        int cnt = map.getOrDefault(num,0);
        int old_pair = cnt*(cnt-1)/2;
        cnt+=d;
        int new_pair = cnt*(cnt-1)/2;
        
        return new_pair-old_pair;
        
        
        
        
    }
}