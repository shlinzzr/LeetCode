// https://leetcode.com/problems/super-egg-drop

class Solution {
     Integer dp[][]= new Integer [101][10001];
    //here e is the number of eggs(k) and f is the number of floors(n)
    public int superEggDrop(int e, int f) {

        if(f==1 || f==0)
            return f;
        if(e==1)
            return f;
        
        if(dp[e][f] != null) return dp[e][f];

        int st=1, ed=f;
        int min= Integer.MAX_VALUE;
        
        while(st<=ed)
        {
            int k = st+ (ed-st)/2; //here k is the middle floor
                
            // if egg breaks when dropped from the kth floor, 
            //then its sure that the egg will break 
            //if dropped from floors above k then we check for floors below k
            // i.e. we go down
                int down = superEggDrop(e-1, k-1); 
            
            // if egg does not break when dropped from the kth floor, 
            //then its sure that the egg will not break 
            //if dropped from floors below k then we check for floors above k
            // i.e. we go up
                int up = superEggDrop(e, f-k);
            
            int temp=1+Math.max(down,up);
            //adding one because we have used 1 attempt and max of up and down because
            //we need worst case attempts from both
            
            if(down < up)
                st= k+1;
            else
                ed= k-1;
        
             min = Math.min(temp, min); //min because we have to find the min no. of moves   
            }
        
        return dp[e][f]=min;  
    }
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