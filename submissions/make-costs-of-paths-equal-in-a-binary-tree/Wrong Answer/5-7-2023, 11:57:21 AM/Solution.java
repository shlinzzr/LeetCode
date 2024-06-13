// https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree

class Solution {
    public int minIncrements(int n, int[] cost) {
        
        int lv = 0;
        int t = n;
        while(t!=0){
            lv++;
            t/=2;
        }
        
        
        
        int cnt = 0;
       while(lv>0){
           
           int max = 0;
           
          
           int st = (int) Math.pow(2, lv-1)-1;
           int ed = (int) Math.pow(2, lv)-1;
           
           // System.out.println(lv + " "+ st + " " + ed);
           
           
         
           int[] arr = new int[ed-st+1];
           
           for(int i=st; i<ed; i++){
               
            int pathsum = 0;
           
                t = i;
               while(t>0){
                   pathsum+= cost[t];
                   t/=2;
               }
               
               
               max =Math.max(max , pathsum);
               arr[i-st]=pathsum;
           }
           
           for(int i=0; i<arr.length-1; i+=2){
               
               if(arr[i]==max || arr[i+1]==max){
                   cnt += max - arr[i];
               }else{
                    int a = max-arr[i];
                   int b = max-arr[i+1];
                   cnt+= Math.abs(a-b);
                      cost[i/2]+=Math.min(a, b);
               }
               
           
                   
           }
           
           // System.out.println(max + " " + cnt);
           
           lv--;
           
       }
        
        return cnt;
        
        
        
        // 100
         // 200 300
             
             
             //  300
        
//                             764
//                     1460                 2664
//                 764   2725             4556    5305
//             8829  5064   5929 7660  6321  4830  7055 3761              
        
    }
}