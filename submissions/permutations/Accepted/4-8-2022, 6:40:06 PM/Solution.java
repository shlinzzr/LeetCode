// https://leetcode.com/problems/permutations

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int num : nums){
            res = combine(res, nums) ;
        }
        
        return res;
        
    }
    
    
    private List<List<Integer>> combine(List<List<Integer>> res, int[] nums){
          System.out.println("res="+Arrays.toString(res.toArray()));
        
       
        List<List<Integer>> ret = new ArrayList<>();
        
        if(res.size()==0){
            
            for(int n : nums){
                List<Integer> list = new ArrayList<>();
                list.add(n); 
                res.add(list);
            }
            return res;
            
          
        }
        
        for(List<Integer> resIn :res){
           
            for(Integer num : nums){
                 ArrayList<Integer> list = new ArrayList<>(resIn);
            
                if(resIn.contains(num)){
                     System.out.println("continue");
                    continue;
                }else{
                 
                    list.add(Integer.valueOf(num));
                }
                ret.add(list);
            }
            
        }
         return ret;
        
    }
}