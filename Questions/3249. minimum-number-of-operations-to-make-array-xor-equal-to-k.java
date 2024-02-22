// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k

class Solution {
    public int minOperations(int[] nums, int k) {
        int len = nums.length;
        
        int xor = 0;
        
        for(int n : nums){
            xor ^= n;
        }
        
        String s = Integer.toBinaryString(xor);
        String t = Integer.toBinaryString(k);
        
        s = new StringBuilder(s).reverse().toString();
        t = new StringBuilder(t).reverse().toString();
        // System.out.println(s + " "  + t);
        int cnt=0;
        
        for(int i=0; i<Math.max(s.length(), t.length()); i++){
            
            if(i<s.length() && i<t.length()){
                
                 // System.out.println(t.charAt(i) + " " + s.charAt(i)+ " " + i + " "+ cnt);
                if(s.charAt(i)!=t.charAt(i)){
                    cnt++;
                }
            }else if(i< s.length()){
                if(s.charAt(i)=='1')
                    cnt++;
            }else if(i <t.length()){
                if(t.charAt(i)=='1')
                    cnt++;
            }
            
           
        }
        
        return cnt;
        
        
        
    }
}