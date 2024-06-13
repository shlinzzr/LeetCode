// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] can, int target) {
        Set<List<Integer>> res = new HashSet<>();
        
        Arrays.sort(can);
        
        helper(can, new ArrayList<>(), res, 0 , target, 0);
        
        return new ArrayList<>(res);
    }
    
    
    private void helper(int[] can , List<Integer> list, Set<List<Integer>> res, int curr, int target, int st){
        
        //  for(int i: can){
        //     System.out.print(i + ",");
        // }
        // System.out.println();
        
        // System.out.println(curr + " " + target  + " "  + st);
        // for(int i: list){
        //     System.out.print(i + ",");
        // }
        // System.out.println();
        
        
        
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
            
        
        for(int i=st; i<can.length; i++){
            if(can[i]<=target ){
                list.add(can[i]);
                
                helper(can, list, res, curr+can[i], target-can[i], i+1);
                
                list.remove(list.size()-1);
            }
        }
    }
    
    
}