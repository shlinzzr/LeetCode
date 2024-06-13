// https://leetcode.com/problems/frog-jump

class Solution {

    TreeSet<Integer> set = new TreeSet<>();
    public boolean canCross(int[] stones) {
        int len = stones.length;

        for(int s : stones){
            set.add(s);
        }

        if(!set.contains(1)) return false;

        return helper(stones, 0, 1);
    }

    private boolean helper(int[] stones, int idx, int k){
        int pos = idx+k; // 1

        if(pos==set.last()) // x
            return true;

        if(pos>set.last()) //x
            return false;

        
        if(k-1>0 && set.contains(pos+k-1)){
            if(helper(stones, pos, k-1))
                return true;
        }

        if(set.contains(pos+k)){ //x
            if(helper(stones, pos, k))
                return true;
        }

        if(set.contains(pos+k+1)){ 
            if(helper(stones, pos, k+1))
                return true;
        }

        return false;
    }
}