// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits

class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        
        for(int i=0;i<nums.size(); i++){
            
            if(getBit(i)==k)
                res+=nums.get(i);
        }
        
        return res;
        
    }
    
    private int getBit(int n){
        int cnt=0;
        
        String s = Integer.toBinaryString(n);
        for(char ch : s.toCharArray()){
            if(ch=='1')
                cnt++;
        }
        
        return cnt;
    }
}