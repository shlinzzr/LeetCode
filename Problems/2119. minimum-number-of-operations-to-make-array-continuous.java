// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous

class Solution {
    public int minOperations(int[] nums) {
        
        int len = nums.length;
        
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        int siz = list.size();
        
        int res = Integer.MAX_VALUE;
        
        int ed=0;
        for(int st=0; st<siz; st++){
            
            while(ed<siz && list.get(ed)-list.get(st) <= len-1){
                res = Math.min(res, len-(ed-st+1));
                ed++;
            }
        }
        
        
        return res;
        
        
    }
}