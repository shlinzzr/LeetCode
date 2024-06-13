// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
//         for(int i=0; i<nums.length-1;i++){
//             if(nums[i]==nums[i+1]){
//                 nums.remove(i);
//             }
//         }
        
        
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            
            HashMap<Integer, Integer> map =new HashMap<>();
            
            for(int j=i+1; j<nums.length; j++){
                if(j==i)
                    continue;
                
                int val = nums[j];
                
                int target = (nums[i] + nums[j]) * -1;
                
                if(map.containsKey(target)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[map.get(target)]);
                    list.add(nums[j]);
                    if(!res.contains(list))
                        res.add(list);
                }else{
                    
                    map.put(val, j);
                    
                }
                
                
            }
        }
        
        return res;
        
    }
}