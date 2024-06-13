// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n = getSquareSum(n);
        }
        
        return n==1;
    }
    
    private int getSquareSum(int n){
        
        int sum = 0;
        while(n>0){
            int mod = n%10;
            
            sum += mod*mod;
            n/=10;
        }
        
        return sum;
        
    }
    
}