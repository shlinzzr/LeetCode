// https://leetcode.com/problems/the-number-of-beautiful-subsets

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet<>();
        
        helper(nums, k, new ArrayList<>(), set, 0);
    
        for(List<Integer> list : set){
            System.out.println(list);
        }
        
        
        return set.size();
    }
    
    private void helper(int[] nums, int k, List<Integer> list, Set<List<Integer>> set, int st){
        
        if(list.size()>0)
            set.add(new ArrayList<>(list));
        
        for(int i=st; i<nums.length; i++){
            
            int n = nums[i];
            if(list.size()==0 || !list.contains(n-k)){
                
                list.add(n);
                helper(nums, k, list, set, i+1);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    
    
}