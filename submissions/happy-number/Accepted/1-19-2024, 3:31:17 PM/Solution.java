// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            
            set.add(n);
            
            int cur = 0;
            int t = n;
            
            while(t>0){
                int m = t%10;
                cur+= m*m;
                t/=10;
            }
            
            n=cur;
        }
        
        return n==1;
        
    }
}