// https://leetcode.com/problems/third-maximum-number

class Solution {
    
    
    long m1 =Long.MIN_VALUE;
    long m2 = m1;
    long m3 = m1;
    
    long m4 = m3;
    public int thirdMax(int[] nums) {
        
        
        int len = nums.length;
        
        for(int i =0; i<len ;i++){
            
            long n = (long) nums[i];
            
            if(n>=m1) {
                
                if(n==m1) continue;
                m3=m2;
                m2=m1;
                m1 = n;
                
            }else if(n>=m2){
                if(n==m2) continue;
                m3 = m2;
                m2 = n;
            }else if(n>m3){
                m3 = n;
                
            }
        }
        
        // System.out.println(m1+ " " + m2 + " " + m3);
        return m3==m4 ? (int)m1 :(int) m3;
    }
}
