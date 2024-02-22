// https://leetcode.com/problems/arithmetic-slices-ii-subsequence

class Solution {
    
    // dp
     public int numberOfArithmeticSlices(int[] A) {
         
        // https://leetcode.com/problems/arithmetic-slices-ii-subsequence/discuss/92822/Detailed-explanation-for-Java-O(n2)-solution
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                map[i].put(d, c1 + c2 + 1);
                
                res += c2;
            }
        }

        return res;
         
     }
    
    
    // brute-force : TLE
//     public int numberOfArithmeticSlices(int[] nums) {
//         int len = nums.length;
        
//         List<List<Long>> res = new ArrayList<>();
        
//         helper(nums, res, new ArrayList<>(), 0);
        
//         return res.size();
        
//     }
    
    
//     private void helper(int[] nums, List<List<Long>> res, List<Long> curr, int st){
        
//         if(curr.size()>=3){
//             res.add(new ArrayList<>(curr));
//         }
//         for(int i=st; i<nums.length; i++){
//             long n = (long)nums[i];
//             if(curr.size()>=2){
//                 if(n-curr.get(curr.size()-1) != curr.get(curr.size()-1)-curr.get(curr.size()-2)) 
//                     continue;
//                 curr.add(n);
//                 helper(nums, res, curr, i+1);
//                 curr.remove(curr.size()-1);
                
//             }else{
//                 curr.add(n);
//                 helper(nums, res, curr, i+1);
//                 curr.remove(curr.size()-1);
//             }
//         }
//     }
}