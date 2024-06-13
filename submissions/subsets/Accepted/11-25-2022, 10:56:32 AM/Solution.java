// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(nums , res, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    
    
    private void helper(int[] arr, Set<List<Integer>> res,  List<Integer> curr, int st){
        
        res.add(new ArrayList<>(curr));
        
        
        for(int i=st; i<arr.length; i++){
            curr.add(arr[i]);
            helper(arr, res, curr, i+1);
            curr.remove(curr.size()-1);
        }
        
        
    }
}