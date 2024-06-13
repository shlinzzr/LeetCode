// https://leetcode.com/problems/number-of-beautiful-partitions

class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        int len = s.length();
        
        HashSet<Integer> prime = new HashSet<>(Arrays.asList(2,3,5,7));
        HashSet<Integer> non_prime = new HashSet<>(Arrays.asList(1,4,6,8,9));
        
        if(!prime.contains(s.charAt(0)-'0') || !non_prime.contains(s.charAt(len-1)-'0'))
            return 0;
        
        int res =0;
        
        // int dp = new int[len+1];
        
        HashSet<Integer> list = new HashSet<>();
        
        for(int i=minLength-1; i<len-minLength; i++){
            
            if(non_prime.contains( s.charAt(i)-'0') && prime.contains(s.charAt(i+1)-'0')){
                list.add(i);
                System.out.println(i);
            }
        }
        
        
        //2354 | 218 | 51 | 31
        
        
        int[][] dp = new int[len+1][k+1];
        dp[0][0]=1;
        for(int i=1; i<=len; i++){
            for(int j=1; j<=k; j++){
                
                for(int l : list){
                    dp[i][j] += dp[i-1][j-1];
                }
                    
            }
        }
        
        
        
        
        return dp[len][k];
        
    }
    
}