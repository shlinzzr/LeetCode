// https://leetcode.com/problems/random-pick-with-blacklist

class Solution {

    HashSet<Integer> set;
    int n;
    public Solution(int n, int[] blacklist) {
        set = new HashSet<>();

        for(int b : blacklist){
            set.add(b);
        }
        this.n=n;

    }
    
    public int pick() {
        int res = (int) (Math.random()*n);
        while(set.contains(res)){
            res = (int) (Math.random()*n);
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */