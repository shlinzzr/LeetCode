// https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        //Each subarray of arr with a size greater than limit must contain both 0 and 1.
        // => Each subarray of arr  which at most only contains the "limit" continuous 0 or 1
        // the length of array must be "zero" + "one"
        
        
        // limit==1 1 0 1 0 1 => +-1
        // limit==2, 1 1 0 0 1 1 => +-2
        

            
            
            // one / (zero+1) > limit
        
        // 11011
            
           // zero = 1, one = 4, limit =2
        if( (Double.valueOf(one) /  Double.valueOf(zero+1)) > limit 
           ||  (Double.valueOf(zero)/ Double.valueOf(one+1))>limit) return 0;
        
        // the total cnt are "the con zero 1~limit" + the con one 1~limit
        //全部 - 不符合的
        
        // 2 ^(z+o) - (limit+1 0)
        
        int len = zero + one ;
        
//         len=8
//         subLen = 6
        
//         x x x x x | x x x 
//         0 0 0 0 0   1
//         1 1 1 1 1   0
            
//         0 x x x x   1
            
            
        
        long illegal = 0;
            
        
        
        // zero = 3, one = 3, limit =2
        
        // limit =3 zero =4 one =1 , len 5
        // 00001
        
        for(int subLen=limit+1; subLen<=zero; subLen++){
            
            int z = zero - subLen;

            
            illegal += (len-subLen+1) * combination(one, z);
            
            for(int conOne=limit+1; conOne<=one; conOne++){
                
                int o = one-conOne;
                
                 illegal -= (len-subLen-conOne+1) * combination(o, z);
            }
            
           
        }
        
        11011
        111 
        
        for(int subLen=limit+1; subLen<=one; subLen++){
            
            int o = one-subLen;
            illegal +=( len-subLen+1)*  combination(o, zero); // 1 1==2. 5-3+1
            
            for(int conZero=limit+1; conZero<=zero; conZero++){
            
                int z = zero - conZero;
                illegal -= (len-subLen-conZero+1) * combination(o, z);
            }
        }
           System.out.println( " illegal 1=" + illegal);
        
        long total =  combination(zero, one);
            
            
        
        int M = (int) 1e9+7;
        
        total %=M;
        
        System.out.println(total + " " + illegal);
       
        
        int res =(int) (total - illegal);
        return res < 0 ? 0 :res ;
            
            
        
    }
    
    public  long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 計算排列組合的方法
    public long combination(int n, int m) {
        // 計算 n!⋅m! / (n+m)!
        return factorial(n + m) / (factorial(n) * factorial(m));
    }
}