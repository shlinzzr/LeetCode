// https://leetcode.com/problems/add-to-array-form-of-integer

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
       
        int idx = num.length-1;
        // String kStr = String.valueOf(k);
        // int ik = kStr.length()-1;
        
        List<Integer> res = new ArrayList<>();
        
        
        
        int carry =0;
        while(idx>=0 || k>0 || carry>0){
            int sum = carry;
            if(idx>=0){
                sum+=num[idx];
                idx--;
            }
            
            if(k>0){
                sum+= k%10;
                k/=10;
            }
            
            carry = sum/10;
            res.add(0, sum%10);    
        }
        
        
        
        
        
        return res;
            
    }
}