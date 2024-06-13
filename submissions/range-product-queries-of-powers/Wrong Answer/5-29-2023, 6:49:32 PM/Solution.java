// https://leetcode.com/problems/range-product-queries-of-powers

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        
        int M = (int) 1e9+7;
        
        int p = 1;
        while(p<n){
            list.add(p);
            p*=2;
        }
        
        // for(int i: list)
        //     System.out.println(i);
        
        
        
        int len = queries.length;
        // int[] res = new int[queries.length];
        
        long[] prod = new long[list.size()+1];
        int curr =1;
        for(int i=0; i<list.size(); i++){
           
             
            curr = (curr * list.get(i))%M;
            System.out.println(curr);
              prod[i]=curr; 
          
        }
        
        int result[]=new int[queries.length];
        int j=0;
        for(int []a:queries){
            long res=1;
            for(int i=a[0];i<=a[1];i++){
                res=(res*list.get(i)%M);
            }
            result[j++]=(int)res%M;
        }
        return result;
        
        
//         for(int i=0; i<len; i++){
//             int[] q= queries[i];
            
            
//             res[i] = q[0]==q[1] ? (int)prod[q[1]] : (int)(prod[q[1]]/ (q[0]==q[1])?prod[q[0]]);
            
//         }
        
        // return res;
        // 1 2 4 8 
        // 1 2 8 64
        
        
    }
}