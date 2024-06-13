// https://leetcode.com/problems/decode-ways

class Solution {

    HashMap<Integer, Integer> map= new HashMap<>();
    public int numDecodings(String s) {
        return helper(0, s);
    }

    private int helper(int idx, String s){

        if(map.containsKey(idx))
            return map.get(idx);
            
        if(idx==s.length())
            return 1;

        if(s.charAt(idx)=='0')
            return 0;

        int ans = helper(idx+1, s);
        if(idx+2 <=s.length() && Integer.parseInt(s.substring(idx, idx+2))<=26)
            ans += helper(idx+2, s);

        map.put(idx, ans);

        return ans;
    }
}