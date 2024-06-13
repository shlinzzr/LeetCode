// https://leetcode.com/problems/number-of-ways-to-split-a-string

class Solution {
    public int numWays(String s) {

        HashMap<Integer, Integer> map = new HashMap<>(); // cnt, idx

        int len = s.length();
        int cnt = 0; 
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch=='1'){
                cnt++;
                map.put(cnt, i);
            }
                
        }

        if(cnt%3!=0)
            return 0;
        
        // if(cnt==0) return combination(s.length()-1, 2); //TLE
        if(cnt==0) return (len-1)*(len-2)/2%M;

        int each = cnt/3;
        
        int curr =1;

        long a = map.get(each+1)-map.get(each);
        long b = map.get(2*each+1) - map.get(each*2);
        int M = (int) 1e9+7;

        return (int)(a*b%M);
    }


/* c幾取幾 => "0000" n-1個空格內取兩個分隔 c(n-1)取2 => (n-1)*(n-2)/2*/
    private int combination(int n, int k){
        if(k==0 || k==n){
            return 1;
        }else{
            return combination(n-1, k) + combination(n-1, k-1);
        }
    }
}

/*
10101
1 | 01 | 01
1 | 010 | 1
10 | 10 | 1


*/