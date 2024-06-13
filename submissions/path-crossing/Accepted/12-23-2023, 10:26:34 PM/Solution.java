// https://leetcode.com/problems/path-crossing

class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> seen = new HashSet<>();


        int[] cur = new int[]{0,0};
        seen.add("0_0");
        for(char ch : path.toCharArray()){
            if(ch=='N') cur[0]++;
            if(ch=='S') cur[0]--;
            if(ch=='E') cur[1]++;
            if(ch=='W') cur[1]--;
            
            if(seen.add(cur[0]+"_"+cur[1])==false)
                return true;
        }

        return false;
    }
}