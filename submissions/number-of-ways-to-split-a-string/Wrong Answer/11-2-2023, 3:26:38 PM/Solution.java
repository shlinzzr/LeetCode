// https://leetcode.com/problems/number-of-ways-to-split-a-string

class Solution {
    public int numWays(String s) {

        int len = s.length();
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
        
        int curr =1;

        int oneCnt=0, zeroCnt=0;

        int gap = 0;

        int i=0; 
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='1')
                oneCnt++;
            
            if(each==0 || oneCnt%each==0){
                while(gap<3 && i+1<len && s.charAt(i+1)=='0'){
                  
                    zeroCnt++;
                    i++;
                }

                gap++;
                curr *= (zeroCnt+1);
                zeroCnt=0;
            }

            i++;


            // System.out.println("i="+i + " st="+st + " ed="+ed + " cur="+curr);
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