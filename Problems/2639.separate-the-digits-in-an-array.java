// https://leetcode.com/problems/separate-the-digits-in-an-array

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int len = nums.length;
        
        for(int i=len-1; i>=0; i--){
            int n = nums[i];
            
            while(n>0){
                list.add(0, n%10);
                n/=10;
            }
        }
        
        int[] res= new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
    }
}