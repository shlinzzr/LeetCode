// https://leetcode.com/problems/special-permutations

class Solution {

    int M = (int) 1e9+7;

    public int specialPerm(int[] nums) {
        int len = nums.length;

        
        long[] dp = new long[1<<len];
        // Arrays.fill(dp, -1L);
        long rt = dfs(nums, 0, new ArrayList<>(), 0, dp);

        return (int) (rt%M);
    }

    private long dfs(int[] nums, int cnt,List<Integer> list, int state, long[]dp){

        // System.out.println("dfs cnt="+cnt +  " state="+state + " list="+list);
        if(cnt>=nums.length) return 1;


       
        // if(dp[state]!=0) {
        //      System.out.println("dp[state]="+ dp[state]);
        //      return dp[state];
        // }
        long res = 0;
        for(int j=0; j<nums.length; j++){
            if((state & (1<<j))==0 && (list.isEmpty() || list.get(list.size()-1)%nums[j]==0 || nums[j]%list.get(list.size()-1)==0)){
                int newState = state | (1<<j);
                list.add(nums[j]);
                // System.out.println("cnt="+cnt + " j="+j + " state=" + state + " newState="+newState);
                res = (res + dfs(nums, cnt+1, list, newState, dp)%M)%M;
                list.remove(list.size()-1);
            }
        }

        dp[state] = res%M;
        return res%M;
    }

}