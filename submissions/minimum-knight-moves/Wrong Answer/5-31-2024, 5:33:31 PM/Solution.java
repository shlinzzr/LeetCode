// https://leetcode.com/problems/minimum-knight-moves

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int minKnightMoves(int x, int y) {

        x = Math.abs(x);
        y = Math.abs(y);
        String key = x+"_"+y;

        if(memo.containsKey(key)) return memo.get(key);

        if(x*y==2) return 1;
        if(x==3 && y==0) return 2;
        if(y==3 && x==0) return 2;
        if(x+y==1) return 3;


        int a = minKnightMoves(x-2, y-1);
        int b = minKnightMoves(x-1, y-2);

        int res = 1 + Math.min(a,b);
        memo.put(key, res);

        return res;


        
    }
}