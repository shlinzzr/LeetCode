// https://leetcode.com/problems/substring-with-largest-variance

class Solution {
    public int largestVariance(String s) {
        int len = s.length();

        // for(int i=0; i<len; i++){
        //     for(int win=1; i+win<=len && win<=len ; win++;)
        // }
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<len; i++){
            map.putIfAbsent(s.charAt(i), new ArrayList<>());
            map.get(s.charAt(i)).add(i);
        }
        
        int res = 0;
        int[] dp0 = new int[len+1]; // not contains -1
        int[] dp1 = new int[len+1]; // contains -1

        

        for(char a  : map.keySet()){
            for(char b : map.keySet()){

                if(a==b) continue;
                int cnt0=0, cnt1=Integer.MIN_VALUE/2;
                int i=0, j=0;

                // for(int i=0; i<len; i++){
                while(i<map.get(a).size() || j<map.get(b).size()){

                    if(j==map.get(b).size() || (i<map.get(a).size() && map.get(a).get(i)<map.get(b).get(j))){
                        cnt1 = cnt1 + 1;
                        cnt0 = cnt0 + 1;
                        i++;
                    }else if(i==map.get(a).size() || (j<map.get(b).size() && map.get(b).get(j) < map.get(a).get(i))){
                        cnt1 = Math.max(cnt0, cnt1)-1;
                        cnt0 = 0;
                        j++;
                    }
                    // if(cur==1){
                    //     dp0[i] = (i==0) ? 1 : dp0[i-1] +1;
                    //     dp1[i] = (i==0) ? cur : dp1[i-1] +1;
                    // }else if(cur==-1){
                    //     dp1[i] = Math.max(dp0[i-1], dp1[i-1])-1;
                    //     dp0[i] = 0;
                       
                    // }

                    res = Math.max(res, cnt1);
                }
            }
        }
        return res;
    }
}