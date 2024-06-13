// https://leetcode.com/problems/count-the-digits-that-divide-a-number

class Solution {
    public int countDigits(int num) {
        int[] arr = new int[10];
        
        int tmp= num;
        
        
        int cnt=0;
        while(tmp>0){
            
            int m = tmp%10;
            if(num%m==0)
                cnt++;
            tmp/=10;
        }
        
        return cnt;
        
//         int idx =0;
//         int min = Integer.MAX_VALUE;
//         for(int i=1; i<10; i++){
//             if(min < arr[i] && num%i==0){
//                 idx = i;
//                 min = arr[i];
//             }
//         }
        
//         return idx;
        
    }
}