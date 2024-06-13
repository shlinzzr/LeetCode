// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        // // 1. sort
        // Arrays.sort(nums);
        // for(int i=0; i<nums.length-1; i++){
        //     if(nums[i]==nums[i+1])
        //         return nums[i];
        // }
        // return -1;
        
        // 2. set
        // Set<Integer> set = new HashSet<>();
        // for(int i : nums){
        //     if(set.contains(i))
        //         return i;
        //     set.add(i);
        // }
        // return -1;
        
        
        //3. Negatinve marking
        // for(int i=0; i<nums.length; i++){
        //     int cur = Math.abs(nums[i]);
        //     if(nums[cur]>0){
        //         nums[cur] *= -1;
        //     }else{
        //         return Math.abs(nums[i]);
        //     }
        // }
        // return -1;
        
        // 4. Array as hashmap (recur)
        // return store(nums, 0);
        
        // 4-2. Array as hashmap (iter)
//         while(nums[0]!=nums[nums[0]]){
//             int nxt = nums[nums[0]];
//             nums[nums[0]] = nums[0];
//             nums[0] = nxt;
//         }
//         return nums[0];
        
        // 5 binarySearch
        int low =1, high=nums.length-1;
        int dul = -1;
        while(low<=high){
            int cur = (low+high)/2;
            int cnt=0;
            for(int n: nums){
                if(n<=cur)
                    cnt++;
            }
            if(cnt>cur){
              dul = cur;
              high = cur -1;
            }else{
                low = cur +1;
            }
        }
        return dul;
        
        
        
        
        
        
        
        
        
    }
    
    // // 4. Array as hashmap
    // private int store(int[] nums, int cur){
    //     if(cur==nums[cur])
    //         return cur;
    //     int next = nums[cur];
    //     nums[cur] = cur;
    //     return store(nums, next);
    // }
}