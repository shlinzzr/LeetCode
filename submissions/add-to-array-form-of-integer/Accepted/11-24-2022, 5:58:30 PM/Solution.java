// https://leetcode.com/problems/add-to-array-form-of-integer

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
       
        int idx = num.length-1;
        String kStr = String.valueOf(k);
        int ik = kStr.length()-1;
        
        List<Integer> res = new ArrayList<>();
        
        
        
        int carry =0;
        while(idx>=0 || ik>=0 || carry>0){
            int sum = carry;
            if(idx>=0){
                sum+=num[idx];
                idx--;
            }
            
            if(ik>=0){
                sum+= kStr.charAt(ik)-'0';
                ik--;
            }
            
            carry = sum/10;
            res.add(0, sum%10);    
        }
        
        
        
        
        
        return res;
            
    }
}