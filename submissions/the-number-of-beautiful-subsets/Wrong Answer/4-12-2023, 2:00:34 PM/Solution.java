// https://leetcode.com/problems/the-number-of-beautiful-subsets

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet<>();
        
        helper(nums, k, new ArrayList<>(), set, 0);
    
        return set.size();
    }
    
    private void helper(int[] nums, int k, List<Integer> list, Set<List<Integer>> set, int st){
        
         if(st==nums.length){
             set.add(new ArrayList<>(list));
         }
        
        for(int i=st; i<nums.length; i++){
            
            int n = nums[i];
            if(list.size()==0 || n-list.get(list.size()-1)!=k){
                
                list.add(n);
                helper(nums, k, list, set, i+1);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    
    
}