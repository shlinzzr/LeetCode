// https://leetcode.com/problems/count-beautiful-substrings-ii

class Solution {
    public int beautifulSubstrings(String s, int k) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
         // System.out.println(set);
        int len = s.length();
        
        int[] presum = new int[len];
        int cnt = 0;
        for(int i=0;i<len; i++){
            presum[i]=(i==0 ? (set.contains(s.charAt(i)) ? 1 : 0) : (presum[i-1] + (set.contains(s.charAt(i)) ? 1:0 )));
              // System.out.println(presum[i]);
        }
        
        int res=0;
        for(int ed=0; ed<len; ed++){
            for(int st=0; st<ed ;st++){
                
                int win = ed-st+1;
                if( win%2==1)
                    continue;
                
                int v=presum[ed]-(st-1<0? 0 : presum[st-1]);
                int c = win - v;
                
                // System.out.println("ed="+ed + " st="+ st + " v="+ v+" c="+c);
                if(v==c && v*c%k==0)
                    res++;
            }
        }
        
        return res;
    }
}
