// https://leetcode.com/problems/decompress-run-length-encoded-list

class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i+=2){
            
            int loop = nums[i];
            int n = nums[i+1];
            for(int j=0; j<loop;j++)
                list.add(n);
        }
        
        int[] res = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
        
        
    }
}