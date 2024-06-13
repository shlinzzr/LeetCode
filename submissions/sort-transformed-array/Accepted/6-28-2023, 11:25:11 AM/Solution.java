// https://leetcode.com/problems/sort-transformed-array

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
        int len = nums.length;
        
        int[] res = new int[len];
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            
            int x=nums[i];
            
            int val = a*x*x + b*x + c;
            list.add(val);
            
        }
        
        Collections.sort(list);
        
        for(int i=0; i<len; i++){
            
            res[i] = list.get(i);
        }
        
        return res;
        
        
    }
}