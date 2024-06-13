// https://leetcode.com/problems/divisor-game

class Solution {
    public boolean divisorGame(int n) {
        
        
        
        // choose x == 1~n-1  & n%x=0,  replace n with n-x;
        
        // 10 n=1 pick n=2, 
        
        if(n==1) return false;
        if(n==2) return true;
        
        // n=1, false
        // n=2, true
        // n=3, false
        // n=4, true // n=3 bob, 
        // n=5, false
        // n=6, true
        // n=7, false
        // n=8
        
        
        boolean[] dp = new boolean[n+1];
        dp[1]=false;
        dp[2]=true;
        // dp[3]=false;
        // dp[4]=false;
        // dp[5]=false;
        // dp[6]=true;
        
        
        for(int i=3; i<=n; i++){
            
            List<Integer> list = getList(i);
           
            boolean flag = false;
            for(int j : list){
                
                if(j==1)
                    continue;
                
                if(dp[j]==false){
                    dp[i]=true;
                    break;
                }
                
                if(dp[i-1]==false || dp[i])
                    dp[i]=true;
            }
            
             System.out.println(i + " "  + list.toString() + " dp="+dp[i]);
                
        }
        
        return dp[n];
        
        
    }
    
    private List<Integer> getList(int n){
        
        List<Integer> list = new ArrayList<>();
            
        for(int i=n-1; i>0; i--){
            if(n%i==0)
                list.add(i);
        }
        
        return list;
    }
    
}