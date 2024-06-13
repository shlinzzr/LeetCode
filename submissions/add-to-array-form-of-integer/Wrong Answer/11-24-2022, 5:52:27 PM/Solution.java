// https://leetcode.com/problems/add-to-array-form-of-integer

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int sum=0;
        for(int n : num){
            sum = sum*10 + n;
        }
        sum+=k;
        
        List<Integer> list = new ArrayList<>();
        
        while(sum>0){
            list.add(0, sum%10);
            sum=sum/10;
        }
        
        
        return list;
            
    }
}