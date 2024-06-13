// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        
        List<Integer> in = new ArrayList<>();
        for(int n: nums){
            in.add(n);
        }
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[] bool = new boolean[nums.length];
        
        helper(nums, res, bool, new ArrayList<>());
        
//         System.out.println(res.indexOf(in));
        
//         for(List<Integer> list : res){
//             System.out.println(list.toString());
//         }
        
        List<Integer> out = res.get( (res.indexOf(in)+1)%res.size());
        for(int i=0; i<out.size(); i++){
            nums[i] = out.get(i);
        }
        
        
        
    }
    
    private void helper(int[] nums,  List<List<Integer>> res ,  boolean[] bool, List<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(bool[i]==false){
                bool[i]=true;
                list.add(nums[i]);
                helper(nums, res, bool, list);
                list.remove(list.size()-1);
                bool[i]=false;
            }
        }
        
        
    }
}