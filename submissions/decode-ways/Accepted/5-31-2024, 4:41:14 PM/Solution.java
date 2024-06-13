// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        
        int len = s.length();

        return helper(s, 0, new HashMap<>());
    }

    private int helper(String s, int idx, Map<Integer,Integer> memo){
        if(idx==s.length()) return 1;
        if(memo.containsKey(idx)) return memo.get(idx);

        char ch = s.charAt(idx);

        int res = 0;
        if(ch=='0') return 0;
        else if(ch=='1'){
            res += helper(s, idx+1, memo);
            if(idx+1<s.length()){
                res+= helper(s, idx+2, memo);
            }
        }else if(ch=='2'){
            res += helper(s, idx+1, memo);
            if(idx+1<s.length()){
                char ch2 = s.charAt(idx+1);
                if(ch2>='0' && ch2<='6'){
                    res+= helper(s, idx+2, memo);
                }
            }
            
        }else{
            res += helper(s, idx+1, memo);
        }

        memo.put(idx, res);
        return res;

    }
}