// https://leetcode.com/problems/flip-game-ii

class Solution {
    public boolean canWin(String state) {
        
       return helper(state, true);

    }


    private boolean helper(String s, boolean isFirst){

        List<String> list = genNext(s);
        if(list.isEmpty())
            return !isFirst;

        boolean res = false;
        for(String next : list){
            if(helper(next, !isFirst))
                return isFirst;
        }

        return res;
    }

    private List<String> genNext(String state){

        List<String> res = new ArrayList<>();
        int len = state.length();
        char[] arr = state.toCharArray();

        int idx = state.indexOf("++");
        while(idx>=0){
            arr[idx]='-';
            arr[idx+1]='-';
            res.add(new String(arr));
            arr = state.toCharArray();
            idx = state.indexOf("++", idx+1);
        }

        return res;
    }
}