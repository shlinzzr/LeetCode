// https://leetcode.com/problems/number-of-substrings-with-fixed-ratio

class Solution {
    public long fixedRatio(String s, int num1, int num2) {
        int len = s.length();
        // 0 : num1, 1 : num2
        
//         HashMap<Integer, Integer> omap = new HashMap<>();
//         HashMap<Integer, Integer> zmap = new HashMap<>();
        
//         int po = 0;
//         int pz = 0;
        
//         for(int i=0; i<len; i++){
//             char ch = s.charAt(i);
//             if(ch=='0'){
//                 po++;
//             }else{
//                 pz++;
//             }
            
//             if(po%num1==0 && pz%num2==0 && po/num1==pz/num2){
                
//             }
            
//         }
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0_0", 1);
        
        long a = 0, b = 0;
        long ret = 0;
        for (char ch: s.toCharArray()){
            if (ch=='0') 
                a++;
            else 
                b++;

            long k = Math.min(a/num1, b/num2);
            long x = a-k*num1, y = b-k*num2;

            String key = x + "_" + y;
            
            if(map.containsKey(key))
                ret += map.get(key);

            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        return ret;
        
    }
}