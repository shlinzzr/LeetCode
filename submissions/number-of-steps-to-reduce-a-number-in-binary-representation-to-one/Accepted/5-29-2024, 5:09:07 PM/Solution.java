// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one

class Solution {
    public int numSteps(String s) {
      
        int len = s.length();

        int res= 0;
        int cnt =0 ;
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='1') cnt++;
        }

        int carry = 0;

        // 1101

        // 1110

        char[] arr = s.toCharArray();


        for(int i=len-1; i>0; i--){ // we just take care of i from [len-1, 1]
            res++; // move
            if(arr[i]-'0'+ carry==1){//(d==1 && carry==0) || (d==0 && carry=1)
                if(i==0) continue;
                res++; // add one
                carry = 1; // for carry, we need to add 1 to digit[i], so carry equal 1
            }
        }

        return res+carry;
        
        
    }
}