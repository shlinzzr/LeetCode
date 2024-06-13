// https://leetcode.com/problems/super-egg-drop

class Solution {

    Integer[][] dp = new Integer[101][10001];

    public int superEggDrop(int k, int n) {

        if(k==1) return n;
        if(n==0 || n==1) return n;

        if(dp[k][n]!=null) return dp[k][n];

        int st=1, ed=n;
        int res = Integer.MAX_VALUE;

        while(st<ed){
            int mid = st+(ed-st)/2;
            
            // egg broke
            int broke = superEggDrop(k-1, mid-1); // broke and go down
            int notBroke = superEggDrop(k, n-mid); // not broke and go up

            int temp = 1 + Math.max(broke, notBroke);

            if(broke<notBroke){ // find min
                st = mid+1;
            }else{
                ed = mid-1;
            }

            res = Math.min(temp, res);
                
        }

        dp[k][n] = res;
        return res;






    }


    // public int superEggDrop1(int k, int n) {
    //     // find f:  0 <= f <= n

    //     // k eggs, floors n
    //     int[][] dp = new int[k+1][0][n]; // min # of move to check f with first i egg at floor j1 ~ j2


    //     // if not broke
    //     dp[i+1][j1][j2] = dp[i][(j1+j2)/2+1][j2] // mid+1 ~ ed

    //     // if broke
    //     dp[i+1][j1][j2] = dp[i][j1][(j1+j2)/2]; // st ~ mid
    // }
}