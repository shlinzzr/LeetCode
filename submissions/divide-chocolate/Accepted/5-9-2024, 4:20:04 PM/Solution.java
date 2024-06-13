// https://leetcode.com/problems/divide-chocolate

class Solution {
    public int maximizeSweetness(int[] sw, int k) {

        int len = sw.length;

        int sum = 0 ;
        for(int n : sw){
            sum+=n;
        }

        if(k==0) return sum; //45

        int st=1, ed=sum;
        int res=0;

        while(st<ed){ //0, 1
            int mid = ed-(ed-st)/2; // 5, 11=> 8
            System.out.println(mid);
            if(isOk(sw, mid, k+1)){
                st = mid;
            }else{
                ed = mid-1;
            }
                
        }

        return st;
    }

    private boolean isOk(int[] sw, int need, int k){

        int pc = 0;
        int cur = 0;
        for(int i=0; i<sw.length; i++){
            cur+= sw[i];
            if(cur>=need){
                cur=0;
                pc++;
            }
        }

        return pc>=k;
    }
}