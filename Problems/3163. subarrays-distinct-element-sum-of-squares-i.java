// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i

class Solution {
    public int sumCounts(List<Integer> nums) {
        int size = nums.size();
        int sum = 0;
        
        // HashMap<Integer, Integer> map =new HashMap<>();
        for(int i=0; i<size; i++)
        {
            HashSet<Integer> set = new HashSet<>();
            // int n = nums.get(i);
            // map.put(n, map.getOrDefault(n,0)+1);
            for(int j=i; j<size; j++){
                
                for(int k=i; k<=j; k++){
                                    set.add(nums.get(k));
                }
                sum += set.size()*set.size();
                

            }
            
        }
        
        return sum;
    }
}