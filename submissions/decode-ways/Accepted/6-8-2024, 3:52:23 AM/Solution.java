// https://leetcode.com/problems/decode-ways

class Solution {

    Map<String, Integer> map = new HashMap<>();
    public int numDecodings(String s) {

        if(map.containsKey(s)) return map.get(s);
        int len = s.length();

        if("0".equals(s)) return 0;
       
        if(len==0 || len==1 ) return 1;

        int res= 0 ;

        char ch = s.charAt(0);

        if(ch=='0') return 0;
        else if(ch=='2'){
            if(len>=2 && s.charAt(1)<='6')  
                res= numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            else res= numDecodings(s.substring(1));
        }

        else {
            if(len>=2 && s.charAt(0)=='1') res = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            else res= numDecodings(s.substring(1));
        }
        map.put(s, res);

        return res;
        
    }
}