// https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array

class Solution {
    public int minimumSum(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        int sum =0 ;
        int val = 1;
        for(int i=0; i<n; i++){
            
            while(!set.isEmpty() && set.contains(k-val)){
                val++;
            }
            sum+=val;
            System.out.println(val);
            set.add(val++);
        }
        return sum;          
    }
}