// https://leetcode.com/problems/count-the-number-of-good-subarrays

class Solution {
    public long countGood(int[] nums, int k) {
        // Arrays.sort(nums);
        int len = nums.length;
        long res =0;
        
        HashMap<Integer, Long> map = new HashMap<>();
        
        long pairs = 0;
        int ed=0;
        for(int st=0; st<len ; st++){
            
            while(ed<len && pairs<k){
                pairs += diff(map, nums[ed], 1);
                map.put(nums[ed], map.getOrDefault(nums[ed], 0L)+1);
                ed++;
            }
            
            if(pairs>=k){
                res += len-ed+1;   // (len-1)-(ed-1)+1 == len-ed+1
            }
            
    //  [ X  X  X ] X  X  X
    //    i    j-1  j   len-1
    //          ^         ^
            
            
            pairs += diff(map, nums[st], -1);
            map.put(nums[st], map.getOrDefault(nums[st], 0L)-1);
        }
        return res;        
        
    }
    
    private long diff(HashMap<Integer, Long> map, int num, int d){
        
        long cnt = map.getOrDefault(num,0L);
        long old_pair = cnt*(cnt-1)/2;
        cnt+=d;
        long new_pair = cnt*(cnt-1)/2;
        
        return new_pair-old_pair;
        
        
        
        
    }
}