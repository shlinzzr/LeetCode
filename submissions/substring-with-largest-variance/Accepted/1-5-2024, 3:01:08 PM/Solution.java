// https://leetcode.com/problems/substring-with-largest-variance

class Solution {
    public int largestVariance(String s) {
        int len = s.length();

        // for(int i=0; i<len; i++){
        //     for(int win=1; i+win<=len && win<=len ; win++;)
        // }
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int res = 0;
        int[] dp0 = new int[len+1]; // not contains -1
        int[] dp1 = new int[len+1]; // contains -1

       

        for(char a  : map.keySet()){
            for(char b : map.keySet()){

                if(a==b) continue;
                 int cnt0=0, cnt1=Integer.MIN_VALUE/2;

                for(int i=0; i<len; i++){

                    char ch = s.charAt(i);

                    int cur = (ch==a) ? 1 : (ch==b) ? -1 : 0;

                    if(cur==1){
                        cnt1 = cnt1 + 1;
                        cnt0 = cnt0 + 1;
                    }else if(cur==-1){
                        cnt1 = Math.max(cnt0, cnt1)-1;
                        cnt0 = 0;
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