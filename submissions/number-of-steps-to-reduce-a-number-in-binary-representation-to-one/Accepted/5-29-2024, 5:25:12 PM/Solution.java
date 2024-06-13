// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one

class Solution {
    public int numSteps(String s) {

        StringBuilder sb = new StringBuilder(s);
        int carry = 0;
        int res=0;
        int idx = sb.length()-1;
        while(idx>0){

            if(sb.charAt(idx)-'0'+carry ==1){ //0 1, 1 0
                res+=2;
                // sb.setCharAt(idx, '0');
                idx--;
                carry = 1;

            }else if(sb.charAt(idx)=='0' && carry==0){ //0 0
                idx--;
                res++;

            }else if(sb.charAt(idx)=='1' && carry==1){ // 1 1
                idx--;
                res++;
            }else{
                res++;
                idx--;
                System.out.println("not");
            }
        }

        if(s.charAt(0)=='0' && carry==1) return res;
        if(s.charAt(0)=='1' && carry==0) return res;
        if(s.charAt(0)=='0' && carry==1) return res+1;
        if(s.charAt(0)=='1' && carry==1) return res+1;


        return res;

      
        // int len = s.length();

        // int res= 0, carry=0;
        

        // for(int i=len-1; i>0; i--){ // we just take care of i from [len-1, 1]
        //     res++; // move
        //     if(s.charAt(i)-'0'+ carry==1){//(d==1 && carry==0) || (d==0 && carry=1)
        //         if(i==0) continue;
        //         res++; // add one
        //         carry = 1; // for carry, we need to add 1 to digit[i], so carry equal 1
        //     }
        // }

        // return res+carry;
        

    }
}