// https://leetcode.com/problems/number-of-ways-to-split-a-string

class Solution {
    public int numWays(String s) {

        int cnt = 0; 
        for(char ch : s.toCharArray()){
            if(ch=='1')
                cnt++;
        }

        if(cnt%3!=0)
            return 0;
        
        if(cnt==0) 
            return combination(s.length()-1, 2);


        int each = cnt/3;
        
        int st=-1, ed=-1;
        int curr =1;

        cnt= 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='1')
                cnt++;

            if((each==1 || cnt==each+1) && st!=-1){
                ed = i;
                curr *= (ed-st);
            }

            if(cnt==each){
                cnt = 0;
                st = i;
            }

            System.out.println("i="+i + " st="+st + " ed="+ed + " cur="+curr);
        }

        return curr;
    }

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