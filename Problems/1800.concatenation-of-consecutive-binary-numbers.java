// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers

class Solution {
    public int concatenatedBinary(int n) {
        // StringBuilder sb = new StringBuilder();
        // for(int i=1; i<=n; i++){
        //     String s = Integer.toBinaryString(i);
        //     sb.append(s);
        // }
            
        
         long sum = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            sum = ((sum << binary.length()) + i) % 1000000007;
        }
        return (int) sum;
        
    }
    
    
}