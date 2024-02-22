// https://leetcode.com/problems/frog-jump

class Solution {

    Set<Integer> set = new HashSet<>();
    Set<String> failed = new HashSet<>();

    public boolean canCross(int[] stones) {
        
        for(int stone : stones){
            set.add(stone);
        }
        return helper(stones, 0, 0);
    }
    private boolean helper(int[] stones, int pos, int k){
        int len = stones.length;

        if(pos == stones[len-1] ) return true;
        if(!set.contains(pos)) return false;
        if(failed.contains(pos+"_"+k)) return false;


        if(k-1>0 && helper(stones, pos+k-1, k-1))//不往回走
            return true;
        if(k>0 && helper(stones, pos+k, k)) //不原地踏步
            return true;
        if(helper(stones, pos+k+1, k+1))
            return true;
        
        failed.add(pos+"_"+k);
        return false;        
    }
}