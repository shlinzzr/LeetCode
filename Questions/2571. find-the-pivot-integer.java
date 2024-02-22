// https://leetcode.com/problems/find-the-pivot-integer

class Solution {
    public int pivotInteger(int n) {

        int pre =0, post=0;
        int st=1, ed=n;
        while(st<=ed){
            
            if(st==ed && pre==post)
                return st;
            
            if(pre<=post){
                pre+=st;
                st++;
            }else{
                post+=ed;
                ed--;
            }
        }
        
        return -1;            
        
        
    }
}