// https://leetcode.com/problems/diagonal-traverse-ii

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int sum = row + col;
                if (!groups.containsKey(sum)) {
                    groups.put(sum, new ArrayList<Integer>());
                }
                
                groups.get(sum).add(nums.get(row).get(col));
                n++;
            }
        }
        
        int[] ans = new int[n];
        int idx = 0;
        int cnt = 0;
        
        while (groups.containsKey(cnt)) {
            for (int num : groups.get(cnt)) {
                ans[idx] = num;
                idx++;
            }
            
            cnt++;
        }
        
        return ans;
    }
}
