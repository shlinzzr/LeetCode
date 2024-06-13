// https://leetcode.com/problems/sum-of-number-and-its-reverse

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        // abcde
        // edcba
        
        // a+e b+d c+c b+d a+e
        
        // abcd
        //.dcba
        // a+d b+c c+b a+d
        
        // first digit : 0~18
        
        
//         int st=0, ed=num;
        
//         while(st<ed){
            
//             int mid = st + (ed-st)/2;
            
//             int val = mid + reverseDigit(mid);
            
//             System.out.println("st=" + st + " ed="  + ed + " m=" + mid +" reverseDigit=" + reverseDigit(mid) + " v="+ val);
            
//             if(val==num){
//                 return true;
//             }else if(val>num){
//                 ed = mid-1;
//             }else{
//                 st = mid+1;
//             }
//         }
        
//         return (st+reverseDigit(st))==num;
        
        
        // if(num==0)
        //     return true;
        
        for(int i=0; i<=num; i++){
            
            if(i + rev(i)==num)
                return true;
                
        }
        
        return false;
        
        
        
    }
    
    
    private int rev(int n){
        int res =0;
        
        while(n>0){
            res*=10;
            res += n%10;
            n/=10;
        }
        
        return res;
        
        
    }
}