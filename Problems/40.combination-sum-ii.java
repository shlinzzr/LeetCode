// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] can, int target) {
        Set<List<Integer>> res = new HashSet<>();
        
        Arrays.sort(can);
        
        boolean[] used = new boolean[can.length];
        
        helper(can, new ArrayList<>(), res, 0 , target, 0, used);
        
        return new ArrayList<>(res);
    }
    
    
    private void helper(int[] can , List<Integer> list, Set<List<Integer>> res, int curr, int target, int st, boolean[] used){
        
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
            
//             if(target-can[i]<0)
//                 continue;
            
//             if(i>0 && can[i-1]==can[i] )
//                 continue;
           if(used[i]==true || target-can[i]<0)
                continue;
            
            if(i>0 && can[i-1]==can[i] && used[i-1]==false)
                continue;
            
            if(can[i]<=target ){
                
                
                list.add(can[i]);
                   used[i]=true;
                helper(can, list, res, curr+can[i], target-can[i], i+1, used);
                   used[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    
    
}