// https://leetcode.com/problems/the-number-of-beautiful-subsets

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(nums, k, new ArrayList<>(), res, 0);
    
        // for(List<Integer> list : set){
        //     System.out.println(list);
        // }
        
        
        return res.size();
    }
    
    private void helper(int[] nums, int k, List<Integer> list, List<List<Integer>> res, int st){
        
        if(list.size()>0)
            res.add(new ArrayList<>(list));
        
        for(int i=st; i<nums.length; i++){
            
            int n = nums[i];
            if(list.size()==0 || !list.contains(n-k)){
                
                list.add(n);
                helper(nums, k, list, res, i+1);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    
    
}