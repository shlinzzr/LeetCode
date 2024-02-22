// https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array

class Solution {
    public long minimumPossibleSum(int n, int target) {
        long res = 0L;
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        int i=1;
        
        while(set.size()<n){
            
            while(set.contains(target-i)){
                i++;    
            }
            res+=i;
            set.add(i++);
        }
        
        return res;
        
        
    }
}