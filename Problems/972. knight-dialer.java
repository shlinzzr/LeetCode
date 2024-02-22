// https://leetcode.com/problems/knight-dialer

class Solution {
    public int knightDialer(int n) {
        List<List<Integer>> g = buildGraph();
        int M = (int) 1e9+7;
        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        for(int i=2; i<=n; i++){

            int[] dp_old = new int[10];
            System.arraycopy(dp,0, dp_old, 0, 10);

            for(int j=0; j<10; j++){

                dp[j]=0;
                List<Integer> list = g.get(j);
                for(int k : list){
                    dp[j] += dp_old[k];
                    dp[j]%=M;
                }
            }
        }

        int res = 0;
        for(int i =0; i<10; i++){
            res = (res + dp[i])%M;
        }

        return res;



    }

    private List<List<Integer>> buildGraph(){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=9; i++){
            list.add(new ArrayList<>());
        }

        list.get(0).add(4);
        list.get(0).add(6);
        list.get(1).add(8);
        list.get(1).add(6);
        list.get(2).add(7);
        list.get(2).add(9);
        list.get(3).add(4);
        list.get(3).add(8);
        list.get(4).add(3);
        list.get(4).add(9);
        list.get(4).add(0);
        list.get(6).add(1);
        list.get(6).add(7);
        list.get(6).add(0);
        list.get(7).add(2);
        list.get(7).add(6);
        list.get(8).add(1);
        list.get(8).add(3);
        list.get(9).add(2);
        list.get(9).add(4);


        return list;
    }
}