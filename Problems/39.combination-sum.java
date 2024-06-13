// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] can, int target) {
        
        Arrays.sort(can);
        Set<List<Integer>> res = new HashSet<>();
        int len = can.length;
        helper(can, new ArrayList<>(), 0, target, res, 0);
        
        return new ArrayList(res);
        
    }
    
    private void helper(int[] can, List<Integer> list, int curr, int target, Set<List<Integer>> res, int st){
        
        // System.out.println(list.toString() + " curr=" + curr + " t=" + target);
        
        if(target==0){
            res.add(new ArrayList<>(list));
            return ;
        }
        
        for(int i=st; i<can.length; i++){
            // System.out.println("i="+ i + " can[i]=" + can[i] + " if=" +(curr+can[i]<=target) );
            if(can[i]<=target){
                list.add(can[i]);
                helper(can, list, curr+can[i], target-can[i], res, i);
                list.remove(list.size()-1);
            }
            
        }
        
        
    }
}