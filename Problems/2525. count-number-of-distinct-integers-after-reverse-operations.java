// https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations

class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int len = nums.length;
        
        for(int n : nums){
            
            set.add(n);
            set.add(reverseDigit(n));
            
        }
          System.out.println(set);
        return set.size();
        
    }
    
    
    private int reverseDigit(int n ){
        
        int res = 0;
        
        while(n>0){
            res = res*10;
            res += n%10;
            n/=10;
        }
      
        
        return res;
        
        
    }
}