// https://leetcode.com/problems/decode-ways

class Solution {

     HashMap<Integer, Integer> map= new HashMap<>();
    public int numDecodings(String s) {
        
        return helper(s, 0);
    }
    
    private int helper(String s, int idx){
        
        int len = s.length();

        if(map.containsKey(idx)) return map.get(idx);
        
        if(idx==len) return 1;
        if(s.charAt(idx)=='0') return 0; //invalid
        
        int res = helper(s, idx+1);
        
        if(idx+2<=len && "17".equals(s.substring(idx, idx+2))){
            System.out.println( (s.charAt(idx)>='1' && s.charAt(idx)<='2' && s.charAt(idx+1)>='0' && s.charAt(idx+1));
        }


        if(idx<=len-2 && s.charAt(idx)>='1' && s.charAt(idx)<='2' && s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6'){          System.out.println(s.substring(idx, idx+2));
            int val  = helper(s, idx+2);

                      System.out.println(s.substring(idx, idx+2)+ " "+val);
            res+=val;
        }

        map.put(idx, res);
        
        return res;
        
    }

    /*


    2611055971756562

    26 1 10 5 5 9 7 17 5 6 5 6 2
   2 6 1 10 5 5 9 7 1 7 5 6 5 6 2



    */
}