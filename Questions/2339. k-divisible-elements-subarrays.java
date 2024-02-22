// https://leetcode.com/problems/k-divisible-elements-subarrays

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int len = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        
        int cnt = 0;
        
        for(int i=0; i<len ; i++){
            
            int t =k;
            List<Integer> list = new ArrayList<>();
            for(int j=i; j<len && t>=0; j++){
                
                if(nums[j]%p==0)
                    t--;
                
                if(t<0)
                    break;
                      
                
                list.add(nums[j]);
                res.add(new ArrayList<>(list));
                
            }
            // System.out.println(res);
        }
        
        return res.size();
        
        
        
        
        // helper(nums, k, p, res, new ArrayList<>(), 0);
        
    }
    
    
//     private void helper(int[] nums, int k, int p,  List<List<Integer>> res, List<Integer> curr, int st){
        
//         if(k>=0 && curr.size()>0){
//             res.add(new ArrayList<>(curr));
//         }
        
//         if(k<0)
//             return;
        
//         for(int i=st; i<nums.length; i++){
            
//             int n = nums[i];
            
//             if(n%p==0 && k>0){
//                 helper(nums, k-1, p, res, curr, i+1)
//             }
            
//         }
            
        
// [2], [2,3], [2,3,3], [2,3,3,2], [3], [3,3], [3,3,2], [3,3,2,2], [3,2], [3,2,2], and [2,2].
// [     [2, 3, 3, 2, 2],]
//     }
}