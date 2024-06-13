// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int n: nums){
            set.add(n);
        }
        
        int max=1, cnt=1;
        
        
        List<Integer> list = new ArrayList(set);
        for(int i=0; i<list.size()-1; i++){
            
            if(list.get(i)+1==list.get(i+1)){
                cnt++;
            }else{
                cnt=1;
            }
            
            max = Math.max(max, cnt);
            
            
        }
        
        return max;
        
        
    }
}