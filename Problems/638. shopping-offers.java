// https://leetcode.com/problems/shopping-offers

class Solution {
    int[] memo;
 
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int N = price.size();

        memo = new int[1<<24];
        List<List<Integer>> special2 = new ArrayList<>();
        for(int i=0; i<special.size(); i++){
            int sum=0;
            for(int j=0; j<N; j++){
                sum += special.get(i).get(j)*price.get(j);
            }

            if(sum>special.get(i).get(N)){
                special2.add(special.get(i));
            }
        }

        // 1 <= n <= 6
        // 0 <= price[i], needs[i] <= 10, 要用4bit 來存

        // xxxx xxxx xxxx xxxx xxxx        xxxx
        //                     need.get(1) need.get(0)

        int state = 0;
        for(int j=0; j<N; j++){
            state += needs.get(j)<<(j*4);
        }

        return dfs(state, special2, price);
    }

    private int dfs(int state, List<List<Integer>> special2, List<Integer> price){

        if(state==0) return 0;
        if(memo[state]!=0)  return memo[state];

        int N = price.size();

        int res = 0;

        for(int j=0; j<N; j++){
            res += ((state>>(j*4))%16)*price.get(j);
        }

        for(List<Integer> combo : special2){
            boolean flag = true;

            for(int j=0; j<N; j++){
                if((state>>(j*4))%16 < combo.get(j)){
                    flag=false;
                    break;
                }
            }
            if(flag==false) continue;

            int state2 = state;
            for(int j=0; j<N; j++){
                state2 -= (combo.get(j)<<(j*4));
            }
            res = Math.min(res, combo.get(N) + dfs(state2, special2, price));

        }
        memo[state] = res;
        return res;

    }
}