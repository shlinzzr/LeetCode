// https://leetcode.com/problems/substring-xor-queries

class Solution {
    public int[][] substringXorQueries(String s, int[][] q) {
        
        // solution 2 :  爆幹難 完全看不懂
        https://www.youtube.com/watch?v=MZL7xsHCHTE
        
        int len = q.length;
        HashMap<Long, List<Integer>> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.putIfAbsent((long)q[i][0]^q[i][1], new ArrayList<>());
            map.get( (long)q[i][0]^q[i][1] ).add(i);
        }
        
        int[][] res = new int[len][2];
        for(int[] r : res){
            Arrays.fill(r, -1);
        }
        
        for(int win=1; win<=31; win++){
            
            long sum = 0;
            for(int i=0; i<s.length(); i++){
                
                sum = sum*2 + (s.charAt(i)-'0');
                if(i>=win)
                    sum -= (1L<<win) * (s.charAt(i-win)-'0');
                
                 if(map.containsKey(sum)){
                    for(int idx : map.get(sum)){
                        
                        if(res[idx][0]!=-1)
                            break;
                        res[idx] = new int[]{i-win+1, i};
                    }

                }
            }
           
        }
        
        return res;
        
        
        
        
        
        // solution 1 : TLE
        
//         int len = q.length;
//         int[] ans = new int[len];
//         for(int i=0; i<len; i++){
//             ans[i] = q[i][0]^q[i][1];
//         }
        
//         int[][] res = new int[len][2];
        
//         for(int i=0; i<len; i++){
            
//             String str = Integer.toBinaryString(ans[i]);
            
//             int idx = s.indexOf(str);
            
//             if(idx==-1){
//                 res[i][0] = -1;
//                 res[i][1] = -1;
//                 continue;
//             }
            
//             // System.out.println( i + " " + str);
//             res[i][0]=s.indexOf(str);
//             res[i][1]=s.indexOf(str)+str.length()-1;
//         }
        
//         return res;
        
        
        
        
        
        
    }
}