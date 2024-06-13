// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor

class Solution {
    public int numberOfWays(String corridor) {
        int len = corridor.length();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            if(corridor.charAt(i)=='S'){
                list.add(i);
            }
        }

        if(list.size()==0) return 0;
        if(list.size()%2!=0) return 0;

        int M = (int) 1e9+7;

        boolean hasDiv = false;
        int curr = 1;
        for(int i=2; i+2<=list.size(); i+=2){
            int diff = list.get(i)-list.get(i-1);
            curr *= diff;
            curr %= M;
        }


        return curr;
        
    }
}