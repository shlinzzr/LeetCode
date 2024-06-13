// https://leetcode.com/problems/maximum-total-reward-using-operations-i

class Solution {
    public int maxTotalReward(int[] rv) {
        Arrays.sort(rv);
        
        int x= 0 ;
        
        //         j dp[j]<c
        // [ o o o o o o c  ] a=> 
        //         j     i = dp[j]<c 
        
                    
        int len = rv.length;
        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int max = 0;
        for(int i=0; i<len; i++){
            int c = rv[i];
            Set<Integer> tmp = new HashSet<>(set);
            for(int a : set){
                if(a<c){
                    tmp.add(a+c);
                    max = Math.max(max, a+c);
                }
            }
            set = tmp;
            
            
        }
        
        return max;
        
        
        
        
//         int[] dp = new int[len+1];
                    
//         for(int i=1; i<=len; i++){
//             int c = rv[i-1];
//             dp[i] = Math.max(c, dp[i-1]);
            
//             List<Integer> list = new ArrayList<>();
//             for(int j=i-1; j>=0; j--){
                
//                 list.add(0, dp[j]);
                
//                 if(dp[j]<c){
//                     dp[i] = Math.max(dp[i], dp[j]+c);
                    
//                 }
                    
//             }
            
//             System.out.println(dp[i] + " " + list);
//         }
        
//         return dp[len];
        
        // return x;
    }
}