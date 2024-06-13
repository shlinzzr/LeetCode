// https://leetcode.com/problems/third-maximum-number

class Solution {
    
    
    int m1 =Integer.MIN_VALUE;
    int m2 = m1;
    int m3 = m1;
    
    int m4 = m3;
    public int thirdMax(int[] nums) {
        
        
        int len = nums.length;
        
        for(int i =0; i<len ;i++){
            
            int n = nums[i];
            
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
        return m3==m4 ? m1 : m3;
    }
}
