// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
//         HashSet<Integer> set = new HashSet<Integer>();
        
//         for(int n : nums){
            
//             if(set.contains(n))
//                 set.remove(n);
//             else
//                 set.add(n);
//         }
        
//         int res = 0;
//         for(int s :set)
//             res = s;
        
//         return res;
        
        
        int ans = 0;
        for(int n : nums){
            ans ^= n;
        }
        return ans;
        
    }
}