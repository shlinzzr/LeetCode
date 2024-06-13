// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, res, new ArrayList<>(), visited);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, 
                        List<Integer> curr, boolean[] visited){
        
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
        }
        
        for(int i=0;i<nums.length; i++){
            if(visited[i]==false){
                visited[i]=true;
                curr.add(nums[i]);
                helper(nums, res, curr, visited);
                curr.remove(curr.size()-1);
                visited[i]=false;
            }
        }
        
        
    }
}