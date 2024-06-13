// https://leetcode.com/problems/pascals-triangle-ii

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        /*
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        
        
        */
        
        rowIndex++;
        
        
        List<Integer> list = new ArrayList<>();
        
        int[] dp = new int[rowIndex];
        dp[0] = 1;
        for(int i=1; i<=rowIndex; i++){
            
            int[] tmp = Arrays.copyOf(dp, i);
            for(int j=0; j<i ; j++){
                
                dp[j] = (j-1>=0 ? tmp[j-1] :0 ) + tmp[j];
                
                
            }
            
            // for(int d: dp){
            //     System.out.print(d + " ,");
            // }
            // System.out.println();
        }
        
        for(int d: dp){
            list.add(d);
        }
        
        return list;
        
    }
}