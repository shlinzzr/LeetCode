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
        map.put("0_0", 1); // x:0~num1-1, y:0~num2-1
        
        long zero = 0, one = 0;
        long ret = 0;
        for (char ch: s.toCharArray()){
            if (ch=='0') 
                zero++;
            else 
                one++;

            //出现了k次“num1个0 + num2个1"，其中k=min(a/num1,b/num2)
            long k = Math.min(zero/num1, one/num2);
            
            //假设presum长度L里面有zero个0与one个1
            //去除这些完整的循环，剩下的零头的0与1，就代表了“余数”。
            long x = zero-k*num1, y = one-k*num2;

            String key = x + "_" + y;
            
            if(map.containsKey(key))
                ret += map.get(key);

            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        return ret;
        
    }
}