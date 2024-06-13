// https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal

class Solution {
    public long minimumCost(String s) {
        
        long res = 0;
        for (int i = 1;  i < s.length(); ++i)
            if (s.charAt(i) != s.charAt(i-1))
                res += Math.min(i, s.length()- i);
        return res;
    }
        
        
//         int cost = 0;
        
//         int len = s.length();
        
//         int toOne = 0;
//         int toZero = 0;
        
//         for(int i=0; i<len; i++){
//              char ch = s.charAt(i);
            
//             if(i<=len/2){
//                 if(ch=='1')
//                     toOne+=i;
//                 else 
//                     toZero+=i;    
//             }else{
//                 if(ch=='1')
//                     toOne+= len-i-1;
//                 else 
//                     toZero += len-i-1;
//             }
            
//             System.out.println("i="+i + " ch="+ch + " toOne="+toOne+ " ToZero="+toZero);
            
//         }
        
//         return Math.min(toOne, toZero);
        
        
        
        
//         int front= 0; 
//         int end = 0;
//         // i<4
//         for(int i=0; i<len; i++){
            
//             char ch = s.charAt(i);
            
//             if(i<len/2){
//                 if(ch=='1')
//                     front++;
//             }else {
//                 if(ch=='1')
//                     end++;
//             }
//         }
        
//         boolean frontToOne = (front+end>=len/2) ? true : false;
//         boolean endToOne = (front+end>=len/2) ? true : false;
            
        
//         for(int i=0; i<len/2; i++){
//             char ch = s.charAt(i);
            
//             if(frontToOne && ch=='0'){
//                 cost+=i;
//             }else if (frontToOne==false && ch=='1')
//                 cost+=i;
            
//         }
        
//         for(int i=len-1; i>=len/2; i--){
//             char ch = s.charAt(i);
            
//             if(endToOne && ch=='0')
//                 cost+=len-i-1;
//             else if(endToOne==false && ch=='1') {
//                 cost += len-i-1;
//             }
//         }
        
//         return cost;
        
        
        
        
        
        
}