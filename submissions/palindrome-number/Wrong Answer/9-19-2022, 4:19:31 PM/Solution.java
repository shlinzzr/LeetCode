// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        int t = x, len=0;
        
        if(t<0)
            return false;
        
        while(t>0){
            t/=10;
            len++;
        }
        
        Stack<Integer> st = new Stack();
        t=x;
        int cnt =0;
        while(t>0){
            if(cnt<len/2){
                st.push(t%10);    
            }else if(len%2==1 && cnt==len/2){
                //center do nothing
            }else if(st.pop()!=t%10){
                return false;
            }
            t/=10;
        }
    
    
        return true;
        
        
        
        
    }
}