// https://leetcode.com/problems/double-modular-exponentiation

class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        
        int len = variables.length;
        
        for(int i=0; i<len; i++){
            int[] var = variables[i];
            int a = var[0];
            int b = var[1];
            int c = var[2];
            int m = var[3];
            
            //((ai^bi % 10)^ci) % mi == target
            int ans = (int)Math.pow(a, b)%10;
            ans = (int)Math.pow(ans, c)%m;
            
            if(ans==target) res.add(i);
            
        }
        
        return res;
    }
}