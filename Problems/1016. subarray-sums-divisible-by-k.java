// https://leetcode.com/problems/subarray-sums-divisible-by-k

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int len = nums.length;
        
        
        int sum=0;
        int res = 0;
        for(int i=0; i<len; i++){
            sum = (sum + nums[i]) % k;
            if(sum < 0) 
                sum += k; 
            
            res+=map.getOrDefault(sum, 0);
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
            
            
            
        }
        
        return res;
        
    }
}


// class Solution {
//     public int subarraysDivByK(int[] A, int K) {
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);
//         int count = 0, sum = 0;
//         for(int a : A) {
//             sum = (sum + a) % K;
//             if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
//             count += map.getOrDefault(sum, 0);
//             map.put(sum, map.getOrDefault(sum, 0) + 1);
//         }
//         return count;
//     }
// }