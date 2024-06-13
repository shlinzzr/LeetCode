// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);
        }
        
        int max = 0;
        for(int n : set){
            
            if(!set.contains(n-1)){
                
                int cnt = 1;
                // int t = n;
                while(set.contains(n+1)){
                    cnt++;
                    n++;
                }
                
                max = Math.max(max, cnt);
            }
        }
        
        return max;
        
        

//         for (int it : set) {
//             if (!set.contains(it - 1)) {
//                 int count = 1;
//                 while (set.contains(it + 1)) {
//                     it++;
//                     count++;
//                 }
//                 longest = Math.max(longest, count);
//             }
//         }

//         return longest;
//     }
        
    }
}