// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<=n; i++){
            int x= i;
            int cnt= 0;
            while(x>0){

                if(x%2==1){
                    cnt++;
                }
                x/=2;
            }

            list.add(cnt);
        }

        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }

        return res;
        
    }
}