// https://leetcode.com/problems/last-stone-weight-ii

class Solution {
    public int lastStoneWeightII(int[] stones) {
        

        // 1d - dp
        // boolean[] dp = new boolean[1501];
        // dp[0] = true;
        // int sumA = 0;
        // for (int a : stones) {
        //     sumA += a;
        //     for (int i = Math.min(1500, sumA); i >= a; --i)
        //         dp[i] |= dp[i - a];
        // }
        // for (int i = sumA / 2; i >= 0; --i)
        //     if (dp[i]) return sumA - i - i;
        // return 0;


        // 2d- dp 
        int len = stones.length;

        boolean[][] dp = new boolean[len+1][1501]; //使用了前i個石頭 可以組成x 
        for(int i=0; i<=len; i++){
            dp[i][0]=true; //  不管用了幾種石頭, 都可以組成0
        }

        int sum = 0;
        for(int i=1; i<=len; i++){
            sum += stones[i-1]; //累計
            for (int x = Math.min(1500, sum); x >= stones[i-1]; --x) {  // 查看所有組合數, 若之前可以組, 那就可以往上疊加
                dp[i][x] = dp[i-1][x] || dp[i-1][x - stones[i-1]];
            }
        }
        for (int x = sum / 2; x >= 0; x--) {

            for(int i=0; i<=len; i++){
                if (dp[i][x]) return sum - 2 * x; 
            }
            
        }
        return 0;


        // // huifeng ... 過不了
        // Set<Integer> set = new HashSet<>();
        // set.add(0);

        // for(int a: stones){
        //     Set<Integer> tmp = new HashSet<>(set);
        //     set.clear();
        //     for(int b: tmp){
        //         set.add(a+b);
        //         set.add(a-b);
        //     }
        // }

        // int res = Integer.MAX_VALUE;
        // for(int x: set){
        //     if(x>=0 && res>x);
        //         res = x;
        // }

        // return res;

     
        // int cnt = len ;
        // Arrays.sort(stones);
        // List<Integer> list = new ArrayList<>();
        // for(int s : stones) list.add(s);

        // while(list.size()>1){

        //     List<Integer> next = new ArrayList<>();
        //     for(int i=list.size()-1; i-1>=0; i-=2){
        //         int a = list.get(i);
        //         int b = list.get(i-1);
        //         if(a==b){
        //             cnt-=2;
        //             continue;
        //         }
        //         else{
        //             int abs = Math.abs(a-b);
        //             cnt--;
        //             next.add(abs);
        //         }
        //     }
        //     list = next;
        //     Collections.sort(list);
        // }

        // return list.isEmpty() ? 0 : list.get(0);
        

      
    }
}