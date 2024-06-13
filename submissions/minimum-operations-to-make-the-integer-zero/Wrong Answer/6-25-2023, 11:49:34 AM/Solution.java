// https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero

class Solution {
    
    
    
    
    public int makeTheIntegerZero(int num1, int num2) {
        
        if(num1==0)
            return 0;
        
        if(num1<0 && num2>0)
            return -1;
        
        num1 -= num2;
        
        if(num1<0)
            return -1;
        
        int sq =1;
        while(Math.abs(num1-sq) < Math.abs(num1)){
            sq*=2;
        }
        
        /*
        if(Math.abs(num1-sq) == Math.abs(num1))
            return makeTheIntegerZero(num1-sq, num2)+1;
        */
        
        
        
        return makeTheIntegerZero(num1-sq/2, num2)+1;
        
        
        
        
        
        
        
//         int min = Integer.MAX_VALUE;
        
//         int sq=1;
//         for(int i=0;i<=60; i++){
            
//             int rt = makeTheIntegerZero(num1-num2-sq, num2);
            
//             if(rt!=-1){
//                 min = Math.min(min, rt);
//             }
            
//             sq*=2;
//         }
        
//         return min;
        /*
        HashSet<Integer> set = new HashSet();
        
        int cnt = 1;
        
        int a = 0;
        
        
        while(a!=num1){
            
            a+=num2;
            
            if(a>num1 && num2>0)
                return -1;
            
            int sq = 1;
            while(a+sq*2<=num1 || set.contains(a+sq*2) && Math.abs(a+sq*4-num1)<= Math.abs(a+sq*2-num1)){
                sq*=2; 
            }
            
            a+=sq;
            
            
            if(a==num1)
                return cnt;
            
            cnt++;
            
        }
        
        return -1;*/
        
    }
}