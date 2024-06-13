// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;


        int a=0, b=0, c=0;



        int res = 0;
        int path = 0;
        for(int i=0; i<len; i++){

           
            String s = garbage[i];
            boolean collectG = false;
            boolean collectM = false;
            boolean collectP = false;
            for(char ch : s.toCharArray()){

                if(ch=='G' && collectG==false){
                    collectG=true;
                    a=Math.max(a, i);
                }else  if(ch=='M' && collectM==false){
                    collectM=true;
                    b=Math.max(b, i);

                }else  if(ch=='P' && collectP==false){
                    collectP=true;
                    c=Math.max(c, i);
                }
                res+=1;
            }

        }

          for(int i=1; i<len; i++){
                if(a>=i){
                    res+=travel[i-1];
                }
                if(b>=i){
                    res+=travel[i-1];
                }
                if(c>=i){
                    res+=travel[i-1];
                }
            }

        return res;
    }
}